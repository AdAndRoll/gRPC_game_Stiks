package org.example.dotsandboxes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.TimeUnit;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.dotsandboxes.GameServiceGrpc;
import org.example.dotsandboxes.Dotsandboxes;

public class GameClientWithGUI extends JPanel {
    private static final int GRID_SIZE = 3;
    private static final int DOT_SIZE = 20;

    private final boolean[][] horizontal = new boolean[GRID_SIZE + 1][GRID_SIZE]; // Для горизонтальных линий
    private final boolean[][] vertical = new boolean[GRID_SIZE][GRID_SIZE + 1]; // Для вертикальных линий
    private final char[][] squares = new char[GRID_SIZE][GRID_SIZE]; // Для хранения состояния квадратов

    private boolean player1Turn = true; // Игрок 1 начинает
    private boolean gameFinished = false; // Статус игры
    private Point firstPoint = null; // Первая точка для линии

    private final GameServiceGrpc.GameServiceBlockingStub blockingStub;

    public GameClientWithGUI(GameServiceGrpc.GameServiceBlockingStub blockingStub) {
        this.blockingStub = blockingStub;

        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!gameFinished) {
                    handleMouseClick(e.getX(), e.getY());
                }
            }
        });

        // Подписка на поток обновлений от сервера
        new Thread(this::watchGameUpdates).start();
    }

    private void watchGameUpdates() {
        Dotsandboxes.Empty request = Dotsandboxes.Empty.newBuilder().build();
        blockingStub.watchGame(request).forEachRemaining(this::updateGameState);
    }

    private void updateGameState(Dotsandboxes.GameState gameState) {
        SwingUtilities.invokeLater(() -> {
            player1Turn = gameState.getPlayer1Turn();  // Устанавливаем ход игрока 1

            // Обновляем состояния квадратов
            for (Dotsandboxes.GameState.Square square : gameState.getSquaresList()) {
                int row = square.getRow();
                int col = square.getCol();
                String mark = square.getMark();

                // Обновляем символ в соответствующем квадрате
                squares[row][col] = mark.isEmpty() ? ' ' : mark.charAt(0);
            }

            // Обновляем состояния линий
            for (Dotsandboxes.GameState.Line line : gameState.getLinesList()) {
                int row = line.getRow();
                int col = line.getCol();
                if (line.getDirection() == Dotsandboxes.GameState.Direction.HORIZONTAL) {
                    horizontal[row][col] = true;
                } else {
                    vertical[row][col] = true;
                }
            }

            // Проверяем победителя только если игра завершена
            String winner = gameState.getWinner();
            if (!winner.isEmpty() && !gameFinished) {
                gameFinished = true;
                if (winner.equals("Draw")) {
                    JOptionPane.showMessageDialog(this, "The game is a draw!");
                } else {
                    JOptionPane.showMessageDialog(this, winner + " wins!");
                }
            }

            repaint();  // Перерисовываем панель
        });
    }




    private void handleMouseClick(int x, int y) {
        int panelSize = Math.min(getWidth(), getHeight());
        int cellSize = panelSize / (GRID_SIZE + 2);
        int offset = (panelSize - (GRID_SIZE * cellSize)) / 2;

        int col = (x - offset + cellSize / 2) / cellSize;
        int row = (y - offset + cellSize / 2) / cellSize;

        if (col < 0 || col > GRID_SIZE || row < 0 || row > GRID_SIZE) return;

        Point selectedPoint = new Point(row, col);

        if (firstPoint == null) {
            firstPoint = selectedPoint;
        } else {
            if (isValidMove(firstPoint, selectedPoint)) {
                makeMove(firstPoint, selectedPoint);
                repaint();
            }
            firstPoint = null; // Сброс первой точки после каждой линии
        }

        if (isGameFinished()) {
            gameFinished = true;
            repaint();
        }
    }

    private boolean isValidMove(Point p1, Point p2) {
        int row1 = p1.x, col1 = p1.y;
        int row2 = p2.x, col2 = p2.y;

        // Проверка горизонтальных линий
        if (row1 == row2 && Math.abs(col1 - col2) == 1) {
            return !horizontal[row1][Math.min(col1, col2)]; // Если линия еще не нарисована
        }
        // Проверка вертикальных линий
        else if (col1 == col2 && Math.abs(row1 - row2) == 1) {
            return !vertical[Math.min(row1, row2)][col1]; // Если линия еще не нарисована
        }
        return false; // Если не горизонтальная и не вертикальная линия
    }

    private void makeMove(Point p1, Point p2) {
        try {
            // Создаем запрос на ход
            Dotsandboxes.MakeMoveRequest moveRequest = Dotsandboxes.MakeMoveRequest.newBuilder()
                    .setX1(p1.x)
                    .setY1(p1.y)
                    .setX2(p2.x)
                    .setY2(p2.y)
                    .build();
            // Отправляем запрос на сервер
            blockingStub.makeMove(moveRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isGameFinished() {
        // Проверка завершения игры на клиенте (по локальной сетке)
        return false; // Основная проверка будет на сервере
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int panelSize = Math.min(getWidth(), getHeight());
        int cellSize = panelSize / (GRID_SIZE + 2);
        int offset = (panelSize - (GRID_SIZE * cellSize)) / 2;

        g.setColor(Color.BLACK);
        if (gameFinished) {
            g.drawString("Game Over!", 20, 20);
            return;
        }

        // Вывод текущего хода
        String currentPlayer = player1Turn ? "Player 1 (X)" : "Player 2 (O)";
        g.drawString("Current turn: " + currentPlayer, 20, 20);

        // Рисуем сетку точек
        for (int row = 0; row <= GRID_SIZE-1; row++) {
            for (int col = 0; col <= GRID_SIZE-1; col++) {
                g.fillOval(offset + col * cellSize - DOT_SIZE / 2, offset + row * cellSize - DOT_SIZE / 2, DOT_SIZE, DOT_SIZE);
            }
        }

        // Рисуем линии (горизонтальные и вертикальные)
        for (int row = 0; row <= GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (horizontal[row][col]) {
                    g.drawLine(offset + col * cellSize, offset + row * cellSize, offset + (col + 1) * cellSize, offset + row * cellSize);
                }
            }
        }
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col <= GRID_SIZE; col++) {
                if (vertical[row][col]) {
                    g.drawLine(offset + col * cellSize, offset + row * cellSize, offset + col * cellSize, offset + (row + 1) * cellSize);
                }
            }
        }

        // Рисуем символы (крестики и нолики)
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (squares[row][col] != '\0') {
                    g.drawString(String.valueOf(squares[row][col]), offset + col * cellSize + cellSize / 3, offset + row * cellSize + 2 * cellSize / 3);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
        GameServiceGrpc.GameServiceBlockingStub stub = GameServiceGrpc.newBlockingStub(channel);

        JFrame frame = new JFrame("Dots and Boxes Game");
        GameClientWithGUI gamePanel = new GameClientWithGUI(stub);
        frame.add(gamePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
    }
}

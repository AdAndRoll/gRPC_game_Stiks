package org.example.dotsandboxes;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class GameServerImpl extends GameServiceGrpc.GameServiceImplBase {

    private static final int GRID_SIZE = 3;  // Размер сетки 3x3
    private boolean player1Turn = true;

    // Массивы для хранения информации о нарисованных линиях
    private boolean[][] horizontal = new boolean[GRID_SIZE][GRID_SIZE - 1];  // Горизонтальные линии
    private boolean[][] vertical = new boolean[GRID_SIZE - 1][GRID_SIZE];    // Вертикальные линии

    // Массив для хранения информации о заполненных квадратах
    private boolean[][] squares = new boolean[GRID_SIZE - 1][GRID_SIZE - 1]; // Заполненные квадраты

    // Массив для хранения меток игроков в квадрате (X или O)
    private String[][] squareMarks = new String[GRID_SIZE - 1][GRID_SIZE - 1]; // Массив для хранения меток X и O

    // Список для хранения всех клиентов, которые слушают обновления
    private final List<StreamObserver<Dotsandboxes.GameState>> clients = new ArrayList<>();

    @Override
    public void makeMove(Dotsandboxes.MakeMoveRequest request, StreamObserver<Dotsandboxes.MakeMoveResponse> responseObserver) {
        int x1 = request.getX1();
        int y1 = request.getY1();
        int x2 = request.getX2();
        int y2 = request.getY2();

        // Логика обработки хода
        boolean squareCompleted = false;

        if (x1 == x2 && Math.abs(y1 - y2) == 1) {  // Горизонтальная линия
            horizontal[x1][Math.min(y1, y2)] = true;
            squareCompleted = checkAndUpdateSquares(x1, Math.min(y1, y2), true);
        }
        else if (y1 == y2 && Math.abs(x1 - x2) == 1) {  // Вертикальная линия
            vertical[Math.min(x1, x2)][y1] = true;
            squareCompleted = checkAndUpdateSquares(Math.min(x1, x2), y1, false);
        }

        if (!squareCompleted) {
            togglePlayer();
        }

        // Отправляем всем подключённым клиентам обновления
        sendGameUpdate();

        // Отправляем ответ клиенту, сделавшему ход
        Dotsandboxes.MakeMoveResponse response = Dotsandboxes.MakeMoveResponse.newBuilder()
                .setMessage("Move registered")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private boolean checkAndUpdateSquares(int row, int col, boolean isHorizontal) {
        boolean squareCompleted = false;

        // Проверка, если завершён квадрат
        if (isHorizontal) {
            if (row > 0 && vertical[row - 1][col] && vertical[row - 1][col + 1] && horizontal[row - 1][col]) {
                squares[row - 1][col] = true;
                squareMarks[row - 1][col] = player1Turn ? "X" : "O";  // Ставим метку в зависимости от текущего игрока
                squareCompleted = true;
            }
            if (row < GRID_SIZE - 1 && vertical[row][col] && vertical[row][col + 1] && horizontal[row + 1][col]) {
                squares[row][col] = true;
                squareMarks[row][col] = player1Turn ? "X" : "O";  // Ставим метку в зависимости от текущего игрока
                squareCompleted = true;
            }
        } else {
            if (col > 0 && horizontal[row][col - 1] && horizontal[row + 1][col - 1] && vertical[row][col - 1]) {
                squares[row][col - 1] = true;
                squareMarks[row][col - 1] = player1Turn ? "X" : "O";  // Ставим метку в зависимости от текущего игрока
                squareCompleted = true;
            }
            if (col < GRID_SIZE - 1 && horizontal[row][col] && horizontal[row + 1][col] && vertical[row][col]) {
                squares[row][col] = true;
                squareMarks[row][col] = player1Turn ? "X" : "O";  // Ставим метку в зависимости от текущего игрока
                squareCompleted = true;
            }
        }

        return squareCompleted;
    }

    private void togglePlayer() {
        // Смена игрока
        player1Turn = !player1Turn;
    }

    @Override
    public void watchGame(Dotsandboxes.Empty request, StreamObserver<Dotsandboxes.GameState> responseObserver) {
        // Добавляем клиента в список
        clients.add(responseObserver);

        // Отправляем начальное состояние игры
        Dotsandboxes.GameState gameState = Dotsandboxes.GameState.newBuilder()
                .setGridSize(GRID_SIZE)
                .setPlayer1Turn(player1Turn)
                .addAllLines(getAllLines())
                .addAllSquares(getAllSquares())
                .setWinner(getWinner())  // Добавляем победителя в начальное состояние
                .build();
        responseObserver.onNext(gameState);

        // Отправляем обновления игры
        sendGameUpdate();
    }

    private void sendGameUpdate() {
        // Отправляем обновление всем подключённым клиентам
        Dotsandboxes.GameState gameState = Dotsandboxes.GameState.newBuilder()
                .setGridSize(GRID_SIZE)
                .setPlayer1Turn(player1Turn)
                .addAllLines(getAllLines())
                .addAllSquares(getAllSquares())
                .setWinner(getWinner())  // Добавляем победителя в обновление
                .build();

        for (StreamObserver<Dotsandboxes.GameState> client : clients) {
            client.onNext(gameState);
        }
    }

    // Генерация списка линий (горизонтальных и вертикальных)
    private List<Dotsandboxes.GameState.Line> getAllLines() {
        List<Dotsandboxes.GameState.Line> lines = new ArrayList<>();

        // Добавление горизонтальных линий
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE - 1; j++) {
                if (horizontal[i][j]) {
                    lines.add(Dotsandboxes.GameState.Line.newBuilder()
                            .setRow(i)
                            .setCol(j)
                            .setDirection(Dotsandboxes.GameState.Direction.HORIZONTAL)
                            .build());
                }
            }
        }

        // Добавление вертикальных линий
        for (int i = 0; i < GRID_SIZE - 1; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (vertical[i][j]) {
                    lines.add(Dotsandboxes.GameState.Line.newBuilder()
                            .setRow(i)
                            .setCol(j)
                            .setDirection(Dotsandboxes.GameState.Direction.VERTICAL)
                            .build());
                }
            }
        }

        return lines;
    }

    // Генерация списка заполненных квадратов
    private List<Dotsandboxes.GameState.Square> getAllSquares() {
        List<Dotsandboxes.GameState.Square> squaresList = new ArrayList<>();

        for (int i = 0; i < GRID_SIZE - 1; i++) {
            for (int j = 0; j < GRID_SIZE - 1; j++) {
                if (squares[i][j]) {
                    squaresList.add(Dotsandboxes.GameState.Square.newBuilder()
                            .setRow(i)
                            .setCol(j)
                            .setMark(squareMarks[i][j]) // Добавляем метку
                            .build());
                }
            }
        }

        return squaresList;
    }

    // Подсчёт победителя и возврат его
    private String getWinner() {
        // Проверка, если все линии нарисованы
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE - 1; j++) {
                if (!horizontal[i][j]) return ""; // Если хотя бы одна горизонтальная линия не нарисована
            }
        }

        for (int i = 0; i < GRID_SIZE - 1; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (!vertical[i][j]) return ""; // Если хотя бы одна вертикальная линия не нарисована
            }
        }

        int player1Score = 0;
        int player2Score = 0;

        // Подсчёт заполненных квадратов для каждого игрока
        for (int i = 0; i < GRID_SIZE - 1; i++) {
            for (int j = 0; j < GRID_SIZE - 1; j++) {
                if (squares[i][j]) {
                    if (squareMarks[i][j].equals("X")) {
                        player1Score++;
                    } else if (squareMarks[i][j].equals("O")) {
                        player2Score++;
                    }
                }
            }
        }

        if (player1Score > player2Score) {
            return "Player 1";
        } else if (player2Score > player1Score) {
            return "Player 2";
        } else {
            return "Draw";
        }
    }


public static void main(String[] args) throws InterruptedException {
        // Настроим и запустим сервер
        GameServerImpl server = new GameServerImpl();
        io.grpc.Server grpcServer = io.grpc.ServerBuilder.forPort(50051)
                .addService(server)
                .build();

        try {
            grpcServer.start();
            System.out.println("Server started on port 50051");
            grpcServer.awaitTermination();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}





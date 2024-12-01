package org.example.dotsandboxes;

import io.grpc.stub.StreamObserver;
import java.util.List;
import java.util.ArrayList;

public class GameServerImpl extends GameServiceGrpc.GameServiceImplBase {

    private static final int GRID_SIZE = 3;  // Размер сетки 3x3
    private boolean player1Turn = true;

    // Массивы для хранения информации о нарисованных линиях
    private boolean[][] horizontal = new boolean[GRID_SIZE][GRID_SIZE - 1];  // Горизонтальные линии
    private boolean[][] vertical = new boolean[GRID_SIZE - 1][GRID_SIZE];    // Вертикальные линии

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
        // Для упрощения пока не реализуем логику завершения квадрата
        return false;
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
                .build();

        for (StreamObserver<Dotsandboxes.GameState> client : clients) {
            client.onNext(gameState);
        }
    }

    // Генерация списка линий (горизонтальных и вертикальных)
    private List<Dotsandboxes.Line> getAllLines() {
        List<Dotsandboxes.Line> lines = new ArrayList<>();

        // Добавление горизонтальных линий
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE - 1; j++) {
                if (horizontal[i][j]) {
                    lines.add(Dotsandboxes.Line.newBuilder()
                            .setRow(i)
                            .setCol(j)
                            .setDirection(Dotsandboxes.Direction.HORIZONTAL)
                            .build());
                }
            }
        }

        // Добавление вертикальных линий
        for (int i = 0; i < GRID_SIZE - 1; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (vertical[i][j]) {
                    lines.add(Dotsandboxes.Line.newBuilder()
                            .setRow(i)
                            .setCol(j)
                            .setDirection(Dotsandboxes.Direction.VERTICAL)
                            .build());
                }
            }
        }

        return lines;
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

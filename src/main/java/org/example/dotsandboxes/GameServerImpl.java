package org.example.dotsandboxes;

import io.grpc.stub.StreamObserver;


public class GameServerImpl extends GameServiceGrpc.GameServiceImplBase {

    private boolean player1Turn = true;
    private char[][] squares = new char[2][2]; // Пример поля 2x2 для игры

    @Override
    public void startGame(Dotsandboxes.StartGameRequest request, StreamObserver<Dotsandboxes.StartGameResponse> responseObserver) {
        // Инициализация игры
        String message = "Game started with size " + request.getSize();
        Dotsandboxes.StartGameResponse response = Dotsandboxes.StartGameResponse.newBuilder().setMessage(message).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void makeMove(Dotsandboxes.MakeMoveRequest request, StreamObserver<Dotsandboxes.MakeMoveResponse> responseObserver) {
        // Логика выполнения хода
        Dotsandboxes.MakeMoveResponse response = Dotsandboxes.MakeMoveResponse.newBuilder().setMessage("Move accepted").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getCurrentPlayer(Dotsandboxes.Empty request, StreamObserver<Dotsandboxes.CurrentPlayerResponse> responseObserver) {
        // Получение текущего игрока
        String player = player1Turn ? "Player 1 (X)" : "Player 2 (O)";
        Dotsandboxes.CurrentPlayerResponse response = Dotsandboxes.CurrentPlayerResponse.newBuilder().setPlayer(player).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getWinner(Dotsandboxes.Empty request, StreamObserver<Dotsandboxes.WinnerResponse> responseObserver) {
        // Логика для определения победителя
        String winner = "Player 1 (X)";  // Ваша логика для подсчета победителя
        Dotsandboxes.WinnerResponse response = Dotsandboxes.WinnerResponse.newBuilder().setWinner(winner).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

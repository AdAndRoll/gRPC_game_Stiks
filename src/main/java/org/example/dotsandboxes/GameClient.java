package org.example.dotsandboxes;

import org.example.dotsandboxes.Dotsandboxes.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import javax.swing.*;
import java.awt.*;

public class GameClient {
    private GameServiceGrpc.GameServiceBlockingStub stub;

    public static void main(String[] args) {
        GameClient client = new GameClient();
        client.startGame();
        client.makeMove(0, 0, 0, 1);
        client.getCurrentPlayer();
    }

    public GameClient() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();
        stub = GameServiceGrpc.newBlockingStub(channel);
    }

    public void startGame() {
        Dotsandboxes.StartGameRequest request = Dotsandboxes.StartGameRequest.newBuilder().setSize(2).build();
        Dotsandboxes.StartGameResponse response = stub.startGame(request);
        System.out.println(response.getMessage());
    }

    public void makeMove(int x1, int y1, int x2, int y2) {
        Dotsandboxes.MakeMoveRequest request = Dotsandboxes.MakeMoveRequest.newBuilder()
                .setX1(x1)
                .setY1(y1)
                .setX2(x2)
                .setY2(y2)
                .build();
        Dotsandboxes.MakeMoveResponse response = stub.makeMove(request);
        System.out.println(response.getMessage());
    }

    public void getCurrentPlayer() {
        Empty request = Empty.newBuilder().build();
        Dotsandboxes.CurrentPlayerResponse response = stub.getCurrentPlayer(request);
        System.out.println("Current player: " + response.getPlayer());
    }

    public void getWinner() {
        Empty request = Empty.newBuilder().build();
        Dotsandboxes.WinnerResponse response = stub.getWinner(request);
        System.out.println("Winner: " + response.getWinner());
    }
}

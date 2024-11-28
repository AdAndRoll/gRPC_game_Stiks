package org.example.dotsandboxes;

import javax.swing.*;
import java.awt.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


public class GameClientWithGUI {
    private static GameServiceGrpc.GameServiceBlockingStub blockingStub;

    public static void main(String[] args) {
        // Подключение к серверу gRPC
        String target = "localhost:50051";
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
                .usePlaintext()
                .build();
        blockingStub = GameServiceGrpc.newBlockingStub(channel);

        // Создание окна игры
        JFrame frame = new JFrame("Dots and Boxes Game");
        DotsAndBoxesGamePanel panel = new DotsAndBoxesGamePanel(blockingStub);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}

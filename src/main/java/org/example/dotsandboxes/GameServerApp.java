package org.example.dotsandboxes;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

public class GameServerApp {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Запуск gRPC сервера
        Server server = ServerBuilder.forPort(50051)
                .addService(new GameServerImpl()) // Подключаем нашу логику сервера
                .build();

        System.out.println("Server started, listening on port 50051");
        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("Shutting down gRPC server since JVM is shutting down");
            server.shutdown();
        }));

        server.awaitTermination();
    }
}

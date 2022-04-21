package com.qirsam.http.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer {

    private final ExecutorService pool;
    private final int port;
    private boolean stopped;

    public HttpServer(int port, int poolSize) {
        this.port = port;
        this.pool = Executors.newFixedThreadPool(poolSize);
    }

    public void run() {
        try (var server = new ServerSocket(port)) {
            while (!stopped) {
                var socket = server.accept();
                System.out.println("Socket accepted");
                pool.submit(() -> processSocket(socket));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void processSocket(Socket socket) {
        try (socket;
             var inputStream = new DataInputStream(socket.getInputStream());
             var outputStream = new DataOutputStream(socket.getOutputStream())) {
//            step1 handle request
            System.out.println("Request: " + new String(inputStream.readNBytes(400)));

            Thread.sleep(10000);
//            step2 handle responce
            var body = Files.readAllBytes(Path.of("resources", "example.html"));
            var headers = """
                    HTTP/1.1 200 OK
                    content-type: text/html
                    content-length: %s
                    """.formatted(body.length).getBytes(StandardCharsets.UTF_8);
            outputStream.write(headers);
            outputStream.write(System.lineSeparator().getBytes(StandardCharsets.UTF_8));
            outputStream.write(body);
        } catch (IOException | InterruptedException e) {
            // TODO: 21.04.2022 log error message
            throw new RuntimeException(e);
        }
    }

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }
}

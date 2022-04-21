package com.qirsam.http.client;

import java.io.IOException;
import java.net.URL;

public class UrlExample {
    public static void main(String[] args) throws IOException {
        checkURLTest();
    }

    private static void checkURLofFile() throws IOException {
        var url = new URL("file:/home/qirsam/IdeaProjects/http-servlets-starter/src/com/qirsam/http/socket/DatagramRunner.java");
        var urlConnection = url.openConnection();

        System.out.println(new String(urlConnection.getInputStream().readAllBytes()));
    }

    private static void checkURLTest() throws IOException {
        var url = new URL("https://www.google.com");
        var urlConnection = url.openConnection();
        urlConnection.setDoOutput(true);

        try (var outputStream = urlConnection.getOutputStream()) {
//            outputStream.write();
        }
        System.out.println();
    }
}

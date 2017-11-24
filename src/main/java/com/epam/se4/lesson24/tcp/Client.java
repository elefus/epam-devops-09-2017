package com.epam.se4.lesson24.tcp;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 10_000);
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            System.out.println(socket.getLocalPort());
            out.write("Hello, server!\n");
            out.flush();
            System.out.println("From server: " + in.readLine());
        }
    }
}

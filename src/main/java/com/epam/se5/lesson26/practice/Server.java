package com.epam.se5.lesson26.practice;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10_000);

        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(new HandlerSocket(socket)).start();
        }
    }
}

class HandlerSocket implements Runnable {

    private final Socket socket;

    HandlerSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))){

                String request = in.readLine();
                String[] peaces = request.split(" ");
                String method = peaces[0];
                String uri = peaces[1];
                String protocol = peaces[2];


                System.err.println("process request");
                out.write("HTTP/1.1 200 OK\r\n");
                out.write("Server: SimpleWebServer\r\n");
//                out.write("Content-length: ");

                out.write("\r\n");
                out.write("<html>\r\n");
                out.write("<body>\r\n");
                out.write("<h1>Hello world!</h1>\r\n");
                out.write("</body>\r\n");
                out.write("</html>\r\n");
    } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
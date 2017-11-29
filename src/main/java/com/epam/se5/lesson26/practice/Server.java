package com.epam.se5.lesson26.practice;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10_000);

        while (true) {
            try (Socket clientSocket = serverSocket.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {


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
}
package com.epam.se4.lesson24.udp;

import java.io.IOException;
import java.net.*;

public class Client {

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(10_001);
            byte[] data = "string".getBytes();

            InetAddress address = InetAddress.getLoopbackAddress();
            DatagramPacket packet = new DatagramPacket(data, data.length, address, 10_000);
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

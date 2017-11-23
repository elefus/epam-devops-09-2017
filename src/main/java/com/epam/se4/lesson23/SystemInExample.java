package com.epam.se4.lesson23;

import java.io.IOException;

public class SystemInExample {

    public static void main(String[] args) throws IOException {
        System.out.println((char)System.in.read());
        System.out.println(System.in.available());
        System.out.println((char)System.in.read());
        System.out.println((char)System.in.read());
    }
}

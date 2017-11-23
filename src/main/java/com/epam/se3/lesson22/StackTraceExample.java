package com.epam.se3.lesson22;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class StackTraceExample {

    public static void main(String[] args) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter("123.txt"))) {
            try {
                method1();
            } catch (RuntimeException ex) {
                ex.printStackTrace(writer);
            }
        }
    }

    public static void method1() throws IOException {
        method2();
    }

    public static void method2() {
        RuntimeException runtimeException = new RuntimeException();
        throw runtimeException;
    }
}

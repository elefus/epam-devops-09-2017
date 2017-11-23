package com.epam.se3.lesson22;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExceptionExample {

    public static void main(String[] args) throws Throwable {
        try (MyClass obj = new MyClass()) {

        } catch (Exception e) {
            e.printStackTrace();
        }

        FileWriter writer = null;
        try {
            writer = new FileWriter("123.txt");
            writer.write("123");
        } finally {
            if (writer != null) {
                writer.close();
            }
        }

        try (FileReader reader = new FileReader("123.txt");
             FileWriter writer2 = new FileWriter("123.txt")) {
            reader.read();
        }

        args = new String[10];


        try {
            anotherMethod();
        } catch (Throwable ex) {
            System.out.println("Ex was thrown (2)");
            throw ex;
        }
    }

    private static void anotherMethod() throws IOException, ClassNotFoundException {
        try {
            method();
            System.out.println("123");
        } catch (Error | Exception ex) {
//            ex = new IllegalArgumentException();
            ex.printStackTrace();
        }
    }

    /**
     *
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws IllegalStateException
     */
    private static void method() throws IOException, ClassNotFoundException, IllegalStateException {
        if (true) {
            throw new IOException();
        } else {
            throw new ClassNotFoundException();
        }
    }
}

class MyClass implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("Closed");
    }
}

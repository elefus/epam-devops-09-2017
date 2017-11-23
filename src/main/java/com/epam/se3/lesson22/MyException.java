package com.epam.se3.lesson22;

public class MyException extends RuntimeException {

    public MyException(String message) {
        super(message);
    }

    void reInitializeStackTrace() {
        fillInStackTrace();
    }
}

class Launcher {

    public static void main(String[] args) {
        try {
            method1();
        } catch (MyException ex) {
            ex.printStackTrace();
        }
    }

    public static void method1() {
        try {
            method2();
        } catch (MyException ex) {
            ex.fillInStackTrace();
            throw ex;
        }
    }

    public static void method2() {
        throw new MyException("Thrown");
    }
}
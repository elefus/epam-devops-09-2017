package com.epam.se3.lesson22;

public class RethrowException {

    public static void main(String[] args) {
//        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
//            @Override
//            public void uncaughtException(Thread t, Throwable e) {
//                System.out.println("In thread: " + t + " was thrown " + e);
//            }
//        });

//        Thread.currentThread().setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
//            @Override
//            public void uncaughtException(Thread t, Throwable e) {
//                System.out.println("2");
//            }
//        });

        try {
            method2();
        } catch (RuntimeException ex) {
            StackTraceElement[] stackTrace = ex.getStackTrace();
            System.out.println(stackTrace[0].getClassName());
            System.out.println(stackTrace[0].getMethodName());
            System.out.println(stackTrace[0].getLineNumber());
            throw new IllegalStateException(ex);
        }
        System.out.println();
    }

    public static int method2() {
        try {
            throw new RuntimeException();
        } catch (Exception ex) {
            throw ex;
        } finally {
            throw new IllegalStateException();
        }
    }



}

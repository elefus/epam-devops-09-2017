package com.epam.se6.lesson29;

public class DeadLockExample {

    public static void main(String[] args) throws InterruptedException {
        Integer ref1 = 1;
        Integer ref2 = 2;

        new Thread(() -> {
            try {
                synchronized (ref1) {
                    Thread.sleep(1000);
                    synchronized (ref2) {
                        System.out.println("Completed thread");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        synchronized (ref1) {
            Thread.sleep(1000);
            synchronized (ref2) {
                System.out.println("Completed main");
            }
        }
    }
}

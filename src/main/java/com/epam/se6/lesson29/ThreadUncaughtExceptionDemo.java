package com.epam.se6.lesson29;

public class ThreadUncaughtExceptionDemo {

    public static void main(String[] args) {
        Thread t = new Thread(new SimpleThread());
        t.setUncaughtExceptionHandler((thread, ex) -> System.out.println(thread + " throws exception: " + ex));
        t.start();
    }
}

class SimpleThread implements Runnable {
    public void run() {
        throw new RuntimeException("It is a greate exception.");
    }
}


class UncaughtException {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            throw new RuntimeException("It is a great exception.");
        });
        t.setUncaughtExceptionHandler((t1, e) -> System.out.println(t1 + " throws exception: " + e));
        t.start();
    }
}

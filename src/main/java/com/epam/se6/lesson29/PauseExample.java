package com.epam.se6.lesson29;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class PauseExample {

    public static void main(String[] args) throws InterruptedException {
        ConsoleClock clock = new ConsoleClock();
        clock.start();

        TimeUnit.SECONDS.sleep(2);
        clock.pause();

        new Thread(() -> {
            synchronized (clock) {
                try {
                    Thread.sleep(10_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        TimeUnit.SECONDS.sleep(2);
        clock.resumeMe();
    }
}


class ConsoleClock extends Thread {

    private final Object monitor = new Object();
    private volatile boolean isPaused;

    @Override
    public void run(){
        try {
            for (int i = 0; i < 10; i++) {
                if (isPaused) {
                    synchronized (monitor) {
                        monitor.wait();
                    }
                } else {
                    System.out.println(i + " - " + new SimpleDateFormat("hh/mm/ss").format(new Date()));
                    Thread.sleep(1000);
                }
            }
        }  catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void pause() {
        isPaused = true;
    }

    public void resumeMe() {
        synchronized (monitor) {
            isPaused = false;
            monitor.notify();
        }
    }

}
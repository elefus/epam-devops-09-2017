package com.epam.se6.lesson29;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    public static void main(String[] args) throws InterruptedException {
        Lock lock = null;
        try {
            lock = new ReentrantLock();

            lock.lock();

            Lock finalLock = lock;
            Thread blockedThread = new Thread(() -> {
//                try {
                    System.out.println("Before lock");
                    finalLock.lock();
                    System.out.println("After lock");
                System.out.println(Thread.currentThread().isInterrupted());
//                } catch (InterruptedException e) {
//                    System.out.println("Was interrupted");
//                }
            });
            blockedThread.start();

            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                    blockedThread.interrupt();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();


            Thread.sleep(5000);
            System.out.println("Main ends");
        } finally {
            if (lock != null) {
                lock.unlock();
            }
        }
    }
}

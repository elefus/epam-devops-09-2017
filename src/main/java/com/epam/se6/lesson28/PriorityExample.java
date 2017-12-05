package com.epam.se6.lesson28;

import java.util.concurrent.TimeUnit;

public class PriorityExample {

    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

        Counter counter1 = new Counter(1);
        System.out.println(counter1.getState());
        counter1.setPriority(Thread.MIN_PRIORITY);

        Counter counter2 = new Counter(2);
        counter2.setPriority(Thread.MIN_PRIORITY + 2);

        Counter counter3 = new Counter(3);
        counter3.setPriority((Thread.NORM_PRIORITY + Thread.MAX_PRIORITY) / 2);

        Counter counter4 = new Counter(4);
        counter4.setPriority(Thread.MAX_PRIORITY);

        Counter daemon = new Counter(-1);
        daemon.setDaemon(true);

        counter1.start();
        System.out.println(counter1.getState());
        counter2.start();
        counter3.start();
        counter4.start();
        daemon.start();

        System.out.println(Thread.currentThread());
        Thread.currentThread().setName("Главный поток");
        TimeUnit.SECONDS.sleep(20);
        System.out.println(Thread.currentThread());

        counter1.interrupt();
        System.out.println(counter1.getState());

        counter2.interrupt();
        counter3.interrupt();
        counter4.interrupt();

        counter1.join();
        System.out.println(counter1.getState());

        counter2.join();
        counter3.join();
        counter4.join();

        System.out.println(counter1.getCounter());
        System.out.println(counter2.getCounter());
        System.out.println(counter3.getCounter());
        System.out.println(counter4.getCounter());

        System.out.println("Main end");
    }



}

class Counter extends Thread {

    private int counter;

    public Counter(int number) {
        setName("Counter - " + number);
    }

    @Override
    public void run() {
//        try {
            while (!isInterrupted()) {
//                System.out.println(isStopped);
//                Thread.sleep(20);
                ++counter;
                Thread.yield();
            }
//        } catch (InterruptedException e) {
//        }
        System.out.println(getName() + " end");
    }

    public int getCounter() {
        return counter;
    }
}

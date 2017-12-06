package com.epam.se6.lesson29;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    private List<Integer> list = new ArrayList<>();

    public void setElement(Integer element) {
        list.add(element);
    }

    public Integer getElement() {
        return list.size() > 0 ? list.remove(0) : null;
    }
}

class IntegerSetterGetter extends Thread {
    private SharedResource resource;
    private boolean run;
    private Random rand = new Random();

    public IntegerSetterGetter(String name, SharedResource resource){
        super(name);
        this.resource = resource;
        run = true;
    }

    public void stopThread() {
        run = false;
    }

    public void run() {
        int action;

        try {
            while (run) {
                action = rand.nextInt(1000);
                if (action % 2 == 0) {
                    getIntegersFromResource();
                } else {
                    setIntegersIntoResource();
                }
            }
            System.out.println("Поток " + getName() + " завершил работу.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void getIntegersFromResource() throws InterruptedException {
        Integer number;

        synchronized (resource) {
            System.out.println("Поток " + getName() + " хочет извлечь число.");
            number = resource.getElement();
            while (number == null) {
                System.out.println("Поток " + getName() + " ждет пока очередь заполнится.");
                resource.wait();
                System.out.println("Поток " + getName() + " возобновил работу.");
                number = resource.getElement();
            }
            System.out.println("Поток " + getName() + " извлек число " + number);
        }
    }

    private void setIntegersIntoResource() throws InterruptedException {
        Integer number = rand.nextInt(500);
        synchronized (resource) {
            resource.setElement(number);
            System.out.println("Поток " + getName() + " записал число " + number);
            resource.notify();
        }
    }
}

class Example {

    public static void main(String[] args) throws InterruptedException {
        Integer val = 5;

        new Thread(() -> {
            try {
                Thread.sleep(1_000);
                synchronized (val) {
                    System.out.println("before notify");
                    val.notify();
                    System.out.println("after notify");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Integer val2 = 10;
        synchronized (val) {
            System.out.println("before wait");
            val.wait();
            System.out.println("after wait");
        }
    }
}
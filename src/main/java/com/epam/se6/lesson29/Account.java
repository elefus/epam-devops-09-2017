package com.epam.se6.lesson29;

import java.util.concurrent.ThreadLocalRandom;

public class Account {
    private volatile int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(0, 5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        balance += amount;
    }

    public void withdraw(int amount) {
        int x = balance - amount;
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(0, 5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        balance = x;
    }

    public static synchronized void method() {
        System.out.println("Syncro static method");
    }
}

class OperatorDeposit extends Thread {
    private Account account;

    public OperatorDeposit(Account account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (account) {
                account.deposit(100);
            }
        }
    }
}

class OperatorWithdraw extends Thread {
    private Account account;

    public OperatorWithdraw(Account account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (account) {
                account.withdraw(50);
            }
        }
    }
}

class OperationInspector {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(200);
        OperatorDeposit opD = new OperatorDeposit(account);
        OperatorWithdraw opW = new OperatorWithdraw(account);

        opD.start();
        opW.start();
        new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                System.out.println(account.getBalance());
            }
        }).start();



        opD.join();
        opW.join();


        Account.method();

        // 200
        // 200 + 100 = 300
        // 200 - 50 = 150
        // 300

        System.out.println(account.getBalance());
    }

}


package com.epam.se6.lesson30;

import java.util.List;
import java.util.concurrent.*;

public class Solution {

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();

        Future<Integer> result = service.submit(new CallableThread());

        try {
            result.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static class SimpleThread implements Runnable {

        public int count = 0;

        @Override
        public void run() {
            for (int i = 0; i < 1_000_000_000; i++) {
                count++;
            }
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " " + System.currentTimeMillis() + " " + count);
        }
    }

    public static class CallableThread implements Callable<Integer> {

        private int count = 0;

        @Override
        public Integer call() {
            for (int i = 0; i < 1_000_000; i++) {
                count++;
            }
            try {
                Thread.sleep(2_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return count;
        }
    }
}

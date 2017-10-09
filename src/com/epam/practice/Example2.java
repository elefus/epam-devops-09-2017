package com.epam.practice;

public class Example2 {

    public static void main(String[] args) {
        if (args.length == 0) {
            return;
        }
        String min = args[0];
        String max = min;

        for (int i = 1; i < args.length; i++) {
            if (args[i].length() <= min.length()) {
                min = args[i];
            }
            if (args[i].length() >= max.length()) {
                max = args[i];
            }
        }

        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }
}

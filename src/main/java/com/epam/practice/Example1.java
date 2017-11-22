package com.epam.practice;

public class Example1 {

    public static void main(String[] args) {
        System.out.println(args.length);

        float totalLength = 0;
        for (int i = 0; i < args.length; i++) {
            totalLength += args[i].length();
        }
        System.out.println(totalLength / args.length);

        totalLength = 0;
        for (String currentString : args) {
            totalLength += currentString.length();
        }
        System.out.println(totalLength / args.length);
    }
}

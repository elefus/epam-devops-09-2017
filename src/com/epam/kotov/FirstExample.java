package com.epam.kotov;

public class FirstExample {

    public static void main(String[] args) {

        System.out.println(args.length);

        float totalLength = 0;

        for (String currentString : args) {
            totalLength += totalLength + currentString.length();

        }

        System.out.println( totalLength / args.length );
    }

}

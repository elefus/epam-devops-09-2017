package com.epam.se1;

import com.epam.practice.IntList;

import java.io.PrintStream;

public class Lesson10 {

    {
//        System.out.println(value);
    }

    private final int value;
    private static final IntList STATIC_LIST = initStaticList();
    private static final String STRING_VALUE = "123";

    public final static PrintStream out = null;

    private static IntList initStaticList() {
        IntList staticList = new IntList();
        staticList.add(1);
        staticList.add(2);
        staticList.add(3);
        return staticList;
    }

    static {
        int value = 10;
        System.out.println("Static init block 1 " + value);
//        STATIC_LIST = null;
    }

    {
        System.out.println("Non-static init block 1");
        value = 100;
    }

    static {
        System.out.println("Static init block 2");
    }

    {
        int value = 20;
        System.out.println("Non-static init block 2 " + value);
    }

    Lesson10() {
        System.out.println("Constructor");
    }

    {
        int value = 10;
        System.out.println("Non-static init block 3" + value);
    }

    Lesson10(int value) {
    }

    public static void main(String[] args) {
//        constructorExample();
//        System.out.println(PublicStaticFinalExample.STR);
        new Lesson10();
        new Lesson10();

        {
            int value = 10;
            System.out.println(value);
        }

        try {
            Class<?> clazz = Class.forName("com.epam.se1.Literals");
            System.out.println(clazz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static void constructorExample() {
        Lesson10 lesson10 = new Lesson10();
        lesson10.method(10);

        System.out.println(lesson10.value);
        // method(lesson10, 10);


        new Lesson10(10);
    }

    public void method(Lesson10 this, int value) {
        System.out.println(value);
        System.out.println(this);
    }
}



package com.epam.se1.lesson13;

import java.util.logging.Logger;

public class Visibility {

    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.getField());
    }
}

class A {

    static {
        loadConfig();
    }

    private static final Logger LOG = Logger.getLogger("A");

    private static void loadConfig() {
        LOG.info("Called loadConfig");
    }

    static {
        printStaticValue();
//        System.out.println(staticValue);
        staticValue = 200;
        printStaticValue();
//        System.out.println(staticValue);
    }

    static int staticValue = 300;

    static {
        System.out.println(staticValue);
        staticValue = 100;
        System.out.println(staticValue);
        printStaticValue();
    }

    static void printStaticValue() {
        System.out.println(staticValue);
    }


    protected int field = 100;

    public int getField() {
        return field;
    }
}

class B extends A {

    private static final int someValue = 42;

    static {
        System.out.println(someValue);
    }

    {
        loadConfig();
    }

    private final Logger LOG = Logger.getLogger("A");

    private void loadConfig() {
        LOG.info("Called loadConfig");
    }

    {
        printNonStaticValue();
//        System.out.println(staticValue);
        staticValue = 200;
        printNonStaticValue();
//        System.out.println(staticValue);
    }

    int staticValue = 300;

    {
        System.out.println(staticValue);
        staticValue = 100;
        System.out.println(staticValue);
        printNonStaticValue();
    }

    void printNonStaticValue() {
        System.out.println(staticValue);
    }

    private int field = 200;

    @Override
    public int getField() {
        return field;
    }

    @Override
    public String toString() {
        return String.valueOf(field);
    }
}
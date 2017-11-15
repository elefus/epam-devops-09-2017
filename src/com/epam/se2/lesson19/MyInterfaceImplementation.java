package com.epam.se2.lesson19;

public class MyInterfaceImplementation implements MyInterface1, MyInterface2 {

    @Override
    public int getValue() {
        return MyInterface1.super.getValue();
    }
}

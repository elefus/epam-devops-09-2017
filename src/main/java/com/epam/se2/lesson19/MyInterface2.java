package com.epam.se2.lesson19;

public interface MyInterface2 {

    default int getValue() {
        return -42;
    }
}

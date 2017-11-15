package com.epam.se2.lesson19;

/**
 * Single
 * Abstract
 * Method
 * -
 * interface
 */
@FunctionalInterface
public interface MyInterface3 {

    int getValue();

    default int getValue(String val) {
        return 100;
    }

    static int getValue(Object obj) {
        return 200;
    }
}

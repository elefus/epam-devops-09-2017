package com.epam.se2.lesson14;

import java.io.Serializable;
import java.util.ArrayList;

public class Optional <T extends Cloneable & Serializable> extends Object implements Serializable {

    private final T value;

    public Optional(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

class Example {

    public static void main(String[] args) {
        A a = new A(10);
//        Optional<A> stringOptional = new Optional<>(a);

        java.util.List<Integer> intList = new ArrayList<Integer>();
        intList.add(10);
        int value = intList.get(0);
    }
}

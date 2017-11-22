package com.epam.se2.lesson15;

import java.lang.reflect.Constructor;

public class GenericClass<T> {

    private final T value;

    public GenericClass(T value) {
        this.value = value;
    }

    public GenericClass(Class<? extends T> clazz) {
        try {
            Constructor<? extends T> constructor = clazz.getConstructor(String.class);
            value = constructor.newInstance("10");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}

class Launcher {

    public static void main(String[] args) {
        GenericClass<Double> doubleValue = new GenericClass<>(10.3);

        GenericClass<Integer> instance = new GenericClass<>(Integer.class);
        GenericClass<Double> doubleGenericClass = new GenericClass<>(Double.class);
    }
}
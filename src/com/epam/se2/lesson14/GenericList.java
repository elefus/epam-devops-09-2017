package com.epam.se2.lesson14;

public interface GenericList <T> {

    void add(T value);

    void add(T value, int index);

    void set(T value, int index);

    boolean remove(T value);

    boolean removeAll(T value);

    T removeFrom(int index);

    T get(int index);

    T[] toArray();

    int size();

    int indexOf(T value);

    int lastIndexOf(T value);
}

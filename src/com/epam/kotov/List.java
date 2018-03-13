package com.epam.kotov;

public interface List {

    void add(int value);
    void add(int value, int index);
    void set(int value, int index);
    boolean remove(int value);
    boolean removeAll(int value);
    int removeFrom(int index);
    int get (int index);
    int[] toArray();
    int size();
    int indexOf(int value);
    int lastIndexOf(int value);

}

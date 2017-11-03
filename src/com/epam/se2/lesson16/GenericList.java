package com.epam.se2.lesson16;

public interface GenericList<V, C extends GenericList<V, C>> {

    C add(V value);

    void add(V value, int index);

    void set(V value, int index);

    boolean remove(V value);

    boolean removeAll(V value);

    V removeFrom(int index);

    V get(int index);

    V[] toArray();

    int size();

    int indexOf(V value);

    int lastIndexOf(V value);
}

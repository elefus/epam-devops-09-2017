package com.epam.se2.lesson14;

public interface List {

    ObjectList add (Object value);

    void add(Object value, int index);

    void set(Object value, int index);

    boolean remove(Object value);

    boolean removeAll(Object value);

    Object removeFrom(int index);

    Object get(int index);

    Object[] toArray ();

    int size();

    int indexOf(Object value);

    int lastIndexOf(Object value);
}

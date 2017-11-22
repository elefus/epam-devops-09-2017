package com.epam.se2.lesson16;

public interface GenericArrayList<V> extends GenericList<V, GenericArrayList<V>> {

    void trimToSize();
}

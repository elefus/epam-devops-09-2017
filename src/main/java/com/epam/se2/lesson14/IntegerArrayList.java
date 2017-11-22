package com.epam.se2.lesson14;

import com.epam.practice.Iterator;

public class IntegerArrayList implements GenericList<Number> {
    @Override
    public void add(Number value) {

    }

    @Override
    public void add(Number value, int index) {

    }

    @Override
    public void set(Number value, int index) {

    }

    @Override
    public boolean remove(Number value) {
        return false;
    }

    @Override
    public boolean removeAll(Number value) {
        return false;
    }

    @Override
    public Number removeFrom(int index) {
        return null;
    }

    @Override
    public Number get(int index) {
        return null;
    }

    @Override
    public Number[] toArray() {
        return new Number[0];
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int indexOf(Number value) {
        return 0;
    }

    @Override
    public int lastIndexOf(Number value) {
        return 0;
    }

    @Override
    public Iterator<Number> getIterator() {
        return null;
    }
}

package com.epam.se2.lesson16;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Lesson16 {

    public static void main(String[] args) {
        B value = getValue(1);
        List<Integer> list = getValue(2);
//        System.out.println(value.getValue());

//        String val = getValue("132");
//        Integer intVal = getValue(10);
//        Object value1 = getValue(null);
    }

    public static <T extends Collection<Integer>> T getValue(int val) {
        return val == 1 ? (T) new B() : (T)new ArrayList<Integer>();
    }

    public static <T> T getValue(T value) {
        return value;
    }



}

class A {
   public int getValue() {
       return hashCode();
   }
}

class B extends A implements Collection<Integer> {

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Integer integer) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
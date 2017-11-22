package com.epam.se2.lesson14;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

public class Lesson14 {

    public static void main(String[] args) throws CloneNotSupportedException {
        A a = new A(10);
//        reallyClone(a);

        Comparable<A> comparableToAObject = new A(100);
        System.out.println(comparableToAObject.compareTo(a));

        A[] arr = {new A(10), new A(20), new A(-1)};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr, new InverseAComparator());
        System.out.println(Arrays.toString(arr));

    }



    public static Object reallyClone(Object obj) throws CloneNotSupportedException {
        if (obj instanceof Cloneable) {
            // TODO really clone
            return null;
        } else {
            throw new CloneNotSupportedException(obj.getClass().getName());
        }
    }
}

class InverseAComparator implements Comparator<A> {

    @Override
    public int compare(A o1, A o2) {
        return o2.compareTo(o1);
    }
}

class A implements Comparable<A>, Cloneable, Serializable {

    private final int value;

    private A() {
        value = 42;
    }

    A(int value) {
        this.value = value;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int compareTo(A another) {
        return Integer.compare(value, another.value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public int getValue() {
        return value;
    }

    // 10   100    100   Integer.MIN_VALUE
    // 10   1000   10    10
}

interface MyInterface {
    int method();
}

package com.epam.se2.lesson16;

import com.epam.practice.Iterator;
import com.epam.se2.lesson14.GenericArrayList;

public class GenericArrayListIteratorExample {

    public static void main(String[] args) {
        com.epam.se2.lesson14.GenericArrayList<Integer> intList = new GenericArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(4);

        Iterator<Integer> iterator = intList.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

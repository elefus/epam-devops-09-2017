package com.epam.se5.lesson25;

import java.util.*;

public class SetExample {

    public static void main(String[] args) {
        NavigableSet<Integer> sortedSet = new TreeSet<>();
        sortedSet.add(1);
        sortedSet.add(2);
        sortedSet.add(3);
        sortedSet.add(1);
        sortedSet.add(4);

        System.out.println(sortedSet.size());
        System.out.println(sortedSet.first());
        System.out.println(sortedSet.last());
        System.out.println(sortedSet.headSet(3));
        System.out.println(sortedSet.tailSet(3));
        System.out.println(sortedSet.subSet(1, 4));

        NavigableSet<Integer> integers = sortedSet.descendingSet();
        System.out.println(integers);
        integers.remove(1);
        System.out.println(integers);
        System.out.println(sortedSet);

        HashMap<String, String> map = new HashMap<>();

        Set<A> set = new TreeSet<>();
        set.add(new A());
    }
}

class A {

}
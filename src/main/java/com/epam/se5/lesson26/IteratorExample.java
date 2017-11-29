package com.epam.se5.lesson26;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class IteratorExample {

    public static void main(String[] args) {
//        iterExample();
        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 1));

//        Iterator<Integer> iterator2 = integers.iterator();
//        Iterator<Integer> iterator = integers.iterator();
//        while (iterator.hasNext()) {
//            Integer var = iterator.next();
//            if (var >= 3) {
//                iterator.remove();
//            }
//        }
//        System.out.println(iterator2.next());

        integers.removeIf(var -> var >= 3);
//        for (Integer var : integers) {
//            if (var >= 3) {
//                integers.remove(var);
//            }
//        }
        System.out.println(integers);

        ArrayList list = new ArrayList();
        list.add(1);

        Collections.singleton(1);
    }

    private static void iterExample() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 1);
        Iterator<Integer> iterator = integers.iterator();

        System.out.println("Iterator: " + iterator.next());
        System.out.println("Iterator: " + iterator.next());
        iterator.forEachRemaining(integer -> System.out.println("Iterator: ~" + integer));

        for (Integer val : integers) {
            System.out.println("Foreach: " + val);
        }

        for (int i = 0; i < integers.size(); i++) {
            System.out.println("Fori: " + integers.get(i));
        }

        Set<Integer> set = new HashSet<>(integers);
        System.out.println(set.contains(1));
        for (Integer value : set) {
            System.out.println("Foreach set: " + value);
        }
    }
}

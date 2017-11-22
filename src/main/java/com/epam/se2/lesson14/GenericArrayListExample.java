package com.epam.se2.lesson14;

public class GenericArrayListExample {

    public static void main(String[] args) {
        GenericList<Integer> intList = new GenericArrayList<>();
//        intList.add("123");
        intList.add(1);
        intList.add(2);
        intList.add(10);
        Integer intValue = intList.get(0);

        GenericList<Double> doubleList = new GenericArrayList<>();
        doubleList.add(10.5);
        doubleList.add(120.5);
        doubleList.add(1d);

        GenericList rawTyped = new GenericArrayList();
        rawTyped.add("123");
        rawTyped.add(123);
        rawTyped.add(123d);

        rawTyped = intList;
        rawTyped.set("abc", 0);

        Integer value = intList.get(0);
        System.out.println(intList.get(0));
    }
}

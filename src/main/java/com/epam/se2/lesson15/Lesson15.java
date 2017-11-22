package com.epam.se2.lesson15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lesson15 {

    public static void main(String[] args) {
//        rawGenericsExample();
//        pecsExample();
        NumberComparator<Number> comparator = new NumberComparator<>();
        method(comparator);
    }

    public static void method(NumberComparator<? super Integer> comparator) {
        int compare = comparator.compare(1, 2);
        Object value = comparator.getValue();

        // todo uses comparator
    }



    private static void pecsExample() {
        List<? extends Number> list1 = new ArrayList<Integer>();
        List<? extends Number> list2 = new ArrayList<Double>();
        List<? extends Number> list3 = new ArrayList<Float>();
//        list1.add(Integer.valueOf(1));
//        list1.add(Double.valueOf(0.5));
        Number number = 5.5;
//        list1.add(number);
//        list1.add(new Object());
        list1.add(null);

        Number number1 = list1.get(0);

        List<? super Number> consumer = new ArrayList<Object>();
//        consumer.add("123");
        consumer.add(1);
        consumer.add(4.5);
        consumer.add(4.5F);

        // Producer
        // Extends
        // Consumer
        // Super
    }

    private static void rawGenericsExample() {
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);

        List<Object> list = new ArrayList<>();
        List rawList;

//        list = ints;
        rawList = ints;
        Object firstValue = rawList.get(0);
        if (firstValue instanceof Integer) {
            System.out.println("I'm integer");
        }

        rawList.add(1, "value");
        Object secondValue = rawList.get(1);
        if (secondValue instanceof Integer) {
            System.out.println("I'm integer");
        }

        Object integer = ints.get(1);

        List<Integer> checkedList = Collections.checkedList(ints, Integer.class);
        List rawList2 = checkedList;
        rawList2.add("23");
        System.out.println(rawList2.get(rawList2.size() - 1));
    }
}

class NumberComparator<T extends Number> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Double.compare(o1.doubleValue(), o2.doubleValue());
    }

    public T getValue() {
        return null;
    }
}
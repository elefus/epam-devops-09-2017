package com.epam.se2.lesson15;

import java.util.List;

public class ListUtils {

    public static <T> void fill(List<? super T> list, T value) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, value);
        }
    }

    public static void fillIntList(List<Integer> list, Integer value) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, value);
        }
    }

    public static void fillDoubleList(List<Double> list, Double value) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, value);
        }
    }
}

package com.epam.se5.lesson27;

import java.util.Arrays;
import java.util.List;

public class CollectionsExample {

    public static void main(String[] args) {
        // 1 6 7 4 6 3 5 7 8
        // A B C D E F G H K


        // 1 3 4 5 6 6 7 7 8
        // A F D G B E C H K

        // 2
        // 1 3 4 5 6 6 7 7 8

    }

    private <T> void swap(List<T> list, int x, int y) {
        list.set(x, list.set(y, list.get(x)));
    }
}

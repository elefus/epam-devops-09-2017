package com.epam.se2.lesson18;

import lombok.NonNull;
import lombok.val;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Launcher {

    public static void main(String[] args) {
        HugeClass hugeClass = new HugeClass(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(hugeClass);
        System.out.println(hugeClass.getValue1());

        hugeClass.setValue1(-1);

        HugeClass other = new HugeClass(-1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(hugeClass.equals(other));

        val ref = new ArrayList<String>();


        List<String> list1 = getUsersById(10);
        List<String> list2 = getUsersById(null);
        for (String user : list1) {
            System.out.println(user);
        }
    }

    /**
     *
     * @return null
     */
    private static @NonNull List<String> getUsersById(@NonNull Integer id) {
        // ...
        if (true) {
            return Arrays.asList("Alex", "Semen");
        } else {
            return Collections.emptyList();
        }
    }
}

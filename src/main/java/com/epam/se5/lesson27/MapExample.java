package com.epam.se5.lesson27;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class MapExample {


    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.putIfAbsent(1, "A");
        map.computeIfAbsent(2, key -> "B");

        map.put(3, "C");
        map.computeIfPresent(3, (key, value) -> "+" + value);

        map.compute(4, (key, value) -> {
           if (value == null) {
               return "default";
           } else {
               return null;
           }
        });

        map.compute(4, (key, value) -> {
            if (value == null) {
                return "default";
            } else {
                return null;
            }
        });

        map.forEach((key, value) -> System.out.println(key + " " + value));

        map.getOrDefault(10, "default");

        map.merge(4, "E", (oldValue, newValue) -> oldValue + newValue);
        map.merge(4, "F", (oldValue, newValue) -> oldValue + newValue);

        Map<Integer, String> map2 = new HashMap<>();
        map2.put(1, "~");
        map2.put(4, "~");

        map2.forEach((key, value) -> map.merge(key, value, String::concat));

//        map.compute(4, (key, value) -> value);
        System.out.println(map);
    }
}

package com.epam.practice;

import java.util.Arrays;

public class Example3 {

    public static void main(String... args) {
        String[] names = {"Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex",
                "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron",
                "Kate"};
        int[] times = {341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343,
                317, 265};

//        procedureStyleSolution(names, times);
//        oopSolution1();
        oopSolution2(names, times);
    }

    private static void oopSolution2(String[] names, int[] times) {
        if (names.length != times.length) {
            return;
        }

        Record[] records = new Record[names.length];
        for (int i = 0; i < names.length; i++) {
            records[i] = new Record(names[i], times[i]);
        }
        System.out.println(Arrays.toString(records));

        Arrays.sort(records);
        System.out.println(Arrays.toString(records));

        System.out.println(records[0]);
        System.out.println(records[1]);
    }

    private static void oopSolution1() {
        Record[] records = new Record[]{
                new Record("Elena", 341),
                new Record("Thomas", 273)
                // ...
        };

        Record record = new Record("Alex", 1);
    }

    static class Record implements Comparable<Record> {
        final String name;
        final int time;

        Record(String name, int time) {
            this.name = name;
            this.time = time;
        }

        @Override
        public String toString() {
            return name + ": " + time;
        }

        @Override
        public int compareTo(Record other) {
            return Integer.compare(time, other.time);
        }
    }

    private static void procedureStyleSolution(String[] names, int[] times) {
        int lowestTime = times[0];
        int index = 0;
        for (int i = 1; i < times.length; i++) {
            if (lowestTime >= times[i]) {
                lowestTime = times[i];
                index = i;
            }
        }
        System.out.println(names[index] + ": " + lowestTime);
    }
}


package com.epam.se1;

import java.util.ArrayList;
import java.util.Arrays;

public class Lesson8 {

    private transient int field;
    private volatile int volatileField;

    public static int[] method() {
        return new int[0];
    }


    public static void userMethod() {
        int[] result = method();
        for (int i : result) {
            System.out.println(i);
        }
    }
    public static void main(Object obj, int a, double b, char z) throws IllegalAccessError {

    }

    public static String main(String str) {
        str = str.substring(0, 2);
        System.out.println(str);
        return str;
    }

    public static void mainHack(String[] arg) {
        arg[0] = arg[0].substring(0, 2);
    }

    public static void main(ArrayList list) {
        list = new ArrayList();
        list.add(1);
        System.out.println(list);
    }

    public static void main(int value) {
        value += 1;
        System.out.println(value);
    }

    public static void main(String[] args) {
//        workWithArrays();
//        callOverloadedMethods();
//        stringPoolExample();

        System.exit(0);

        int[] ints = new int[50];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = 100;
        }
        Arrays.fill(ints, 100);


        String str = "abc";
        String[] strArray = new String[10];
        System.out.println(strArray[0]);
        Arrays.fill(strArray, str);

        int[] values = {1, 3, 5};

        String[][] twoDimensional = new String[10][10];
        twoDimensional[0][0] = "123";
        System.out.println(twoDimensional[0][0]);

        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().totalMemory());


        int[] var = null;
        int var2[] = null;
        int[] var3 [] = null;
        int[][] var4 = {
                {1},
                {1, 2},
                {1, 2, 3},
                {1, 2, 3, 4}
        };
        for (int[] row : var4) {
            for (int value : row) {
                System.out.println(value);
            }
        }

        for (int i = 0; i < var4.length; i++) {
            for (int j = 0; j < var4[i].length; j++) {
                System.out.println(var4[i][j]);
            }
        }


        String[] arrString = {"1", "3", "2"};
        String[] sortedArray = arrString.clone();
        Arrays.sort(sortedArray);
        System.out.println(sortedArray[1]);



    }

    private static void stringPoolExample() {
        String a = "a";
        String anotherA = "a";
        String createdA = new String("a");
        String concatA = "" + a;
        String internA = new String(createSomeString()).intern();

        System.out.println(a == anotherA);
        System.out.println(a == createdA);
        System.out.println(a == concatA);
        System.out.println(a == internA);
        System.out.println(a.equalsIgnoreCase("A"));
        System.out.println(a.equals(createdA));


        String b = "b";
        String ab = a + b;
    }

    private static String createSomeString() {
        return "a";
    }

    private static void workWithArrays() {
        int[] arr = {1, 2, 3};
        int[] arr2 = new int[arr.length + 1];
        System.arraycopy(arr, 0, arr2, 0, arr.length);
        int[] ints = Arrays.copyOf(arr, arr.length + 1);


        Object[] objects = new Character[100];
        Character[] characters = (Character[]) objects;

        Number[] numbers = {1, 2, 3};
        numbers[0] = 3d;

        Number[] intNumbers = new Integer[]{1, 2, 3};
        intNumbers[0] = 4d;


        Object value = new Object();
        method(value);
    }

    private static void callOverloadedMethods() {
        int value = 1;
        main(value);
        System.out.println(value);

        ArrayList list = new ArrayList();
        main(list);
        System.out.println(list);

        String str = "hello";
        String modified = main(str);
        System.out.println(modified);
        System.out.println(str);

        String[] strArr = {"hello"};
        mainHack(strArr);
        System.out.println(strArr[0]);
    }


    private static void method(Object value2) {
        System.out.println(value2);
    }

    public static class B {

    }
}

class A {

}

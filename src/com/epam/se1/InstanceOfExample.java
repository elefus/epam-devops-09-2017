package com.epam.se1;

import java.util.ArrayList;
import java.util.List;

public class InstanceOfExample {

    public final int value = 10;
    public final List<String> list = new ArrayList<>();


    public void method() {
//        value = 20;
//        list = null;
//        list = new ArrayList<>();
//        list.add("123");
        nativeMethod();
        System.out.println("123");
    }

    public native int nativeMethod();



    public static void main(String[] args) {
        String string = "abcd";

        System.out.println(string instanceof String);
        System.out.println(string instanceof Object);




        Number number = 1;


        System.out.println("Checking number:");
        System.out.println(number instanceof Integer);
        System.out.println(number instanceof Long);
        System.out.println(number instanceof Double);
        System.out.println(number instanceof Number);
        System.out.println(number instanceof Object);
    }
}

class Inherited extends InstanceOfExample {

    @Override
    public void method() {
        super.method();

        System.out.println("321");
    }
}

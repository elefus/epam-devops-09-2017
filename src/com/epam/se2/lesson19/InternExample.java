package com.epam.se2.lesson19;

import java.util.Objects;

public class InternExample {

    public static void main(String[] args) {
        String a = "a";
        String a2 = "a";
        System.out.println(a == a2);

        String a3 = new String(a2).intern();
        System.out.println(a == a3);


        String abc = "2abc";
        StringBuffer buffer = new StringBuffer("123");
        buffer.delete(0, 1);
        buffer.delete(1, 2);
        System.out.println(buffer.toString());

        buffer.append("abc");
        System.out.println(abc == buffer.toString().intern());

        String ja = "ja1";
        String va = "va";
        String java = ja + va;
        System.out.println(System.identityHashCode(java));

        StringBuilder builder = new StringBuilder(java);
        String javaFromBuilder = builder.toString();
        System.out.println(System.identityHashCode(javaFromBuilder));


        String internJava = java.intern();
        System.out.println(System.identityHashCode(internJava));
        String internFromBuilder = javaFromBuilder.intern();
        System.out.println(System.identityHashCode(internFromBuilder));
        System.out.println(internJava == internFromBuilder);
    }
}

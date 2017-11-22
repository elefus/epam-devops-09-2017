package com.epam.se3.lesson20;

public class FormatterExample {

    public static void main(String[] args) {
        System.out.println("abc");
        System.out.print("abc" + System.lineSeparator());


        System.out.printf("abc%n");

        System.out.printf("%3$d %d %3$d %d %d %1$d %d%n", 1, 2, 3, 4);
        System.out.printf("%d %<d%n", 1);

        System.out.printf("% d%n%(d", 10, -10);

        System.out.println(130);
        System.out.println(0b101011);
        System.out.println(0xFE12);
        System.out.println(01110);
    }
}

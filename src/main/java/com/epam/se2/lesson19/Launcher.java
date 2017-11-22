package com.epam.se2.lesson19;

public class Launcher {

    private int field = 150;

    public static void main(String[] args) {
        MyInterface3 ref = new OldStyleClass();
        System.out.println(ref.getValue());

        int value = 400;
        MyInterface3 anonymous = new MyInterface3() {
            @Override
            public int getValue() {
                return value;
            }
        };

        MyInterface3 lambda = () -> value;

        System.out.println(lambda.getValue());
    }

    private void test() {
        System.out.println(this.field);

        MyInterface3 anonymous = new MyInterface3() {
            @Override
            public int getValue() {
                return field;
            }
        };

        // Statement lambda
        MyInterface3 lambda = () -> {
            System.out.println(field);
            return field;
        };
        field = 200;
        System.out.println(lambda.getValue());

        // Expression lambda
        Runnable runnable = () -> System.out.println("123");
    }
}

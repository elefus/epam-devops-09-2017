package com.epam.se1;

public class AssertionExample implements Cloneable {

    public AssertionExample(int a, int b) {

    }

    public static void main(String...args) {

        // Необходимо указать ключ -ea при старте JVM (для включения assert)
        assert 5 == 6;

        System.out.println("После assert");

        AssertionExample object = new AssertionExample(1, 2);
        object.method();


//        System.out.println(this); <- нельзя обращаться к this в статическом контексте
    }

    private void method() {
        System.out.println(this);
    }
}

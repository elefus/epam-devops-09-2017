package com.epam.se1.lesson13;

public class Lesson13 {

    public static void main(String[] args) {
        Child child = new Child();
        String str = child.toString();
        String parentString = child.parentToString();


        System.out.println(Square.PI);
    }
}


class Parent {

    protected int value = 100;

    @Override
    public String toString() {
        return "I'm parent";
    }
}

class Child extends Parent {

    protected int value = 200;

    @Override
    public String toString() {
        return "I'm child, my parent's value is: " + super.value + " and my own value: " + value;
    }

    protected int getParentValue() {
        return super.value;
    }

    public String parentToString() {
        return super.toString();
    }
}

class GrandChild extends Child {

    @Override
    public String toString() {
        getParentValue();
        return super.toString();
    }
}


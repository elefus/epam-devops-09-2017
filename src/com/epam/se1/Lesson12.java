package com.epam.se1;

public class Lesson12 {

    public static void getArgs(Integer...args) {
        System.out.println("Integers");
    }

    public static void getArgs(Integer[]...args) {
        System.out.println("Integers[]");
    }


//    public static void sum(Object...values) {
//
//    }
//
//    public static void sum(int...values) {
//
//    }


    public static void main(String[] args) {
//        varargsExample();
        createStringFromZeroTo(10);
    }

    private static void varargsExample() {
//        sum(1, 2);
        getArgs(1, 2, 3, 4);
        Integer[] arr = {1, 2, 3, 4};
        getArgs(arr);
        getArgs(arr, arr, arr);
    }

    // 10 -> "0 1 2 3 4 5 6 7 8 9 10"
    // 5 -> "0 1 2 3 4 5"
    static String createStringFromZeroTo(int value) {
        return value == 0 ? "0"
                          : createStringFromZeroTo(value - 1) + " " + value;
    }

    // 2, 5 -> "2 3 4 5"
    // 9, 2 -> "9 8 7 6 5 4 3 2"
    static String createString(int from, int to) {
        return null;
    }


    private static String anotherMethod(int value) {
        return createStringFromZeroTo(value);
    }
}



class Parent extends Object {
    private int privateField;
    int packageField;
    protected int protectedField;
    public int publicField;

    public Parent(int privateField, int packageField, int protectedField, int publicField) {
        this.privateField = privateField;
        this.packageField = packageField;
        this.protectedField = protectedField;
        this.publicField = publicField;
    }

    public void printFieldsInParent(Parent this) {
        System.out.println(privateField);
        System.out.println(packageField);
        System.out.println(protectedField);
        System.out.println(publicField);
    }

    public int getPrivateField() {
        return privateField;
    }
}

class Child extends Parent {

    private String name;

    public Child(int privateField, int packageField, int protectedField, int publicField, String name) {
        super(privateField, packageField, protectedField, publicField);
        this.name = name;
    }

    public void printFieldsInChild() {
        System.out.println(getPrivateField());
        System.out.println(packageField);
        System.out.println(protectedField);
        System.out.println(publicField);
        System.out.println(name);
    }
}

class Launcher {

    public static void main(String[] args) {
        Parent parent = new Parent(1, 2, 3, 4);
        parent.printFieldsInParent();

        Child child = new Child(-1, -2, -3, -4, "abc");
        child.printFieldsInChild();

        Parent base = (Parent) child;
        Child anotherChild = (Child) parent;
        anotherChild.printFieldsInChild();

        Integer val = 1;
        Number number = val;
        Long longValue = (Long) number;


        G gObject = new G(1);
        System.out.println(gObject.toString());

        H hObject = new H();
        System.out.println(hObject.toString());

        G anotherGObject = hObject;
        System.out.println(anotherGObject.toString());
    }
}

class G {
    private int value;

    public G(int value) {
        this.value = value;
    }

    public G(int value, String string) {
        this.value = value;
        System.out.println(string);
    }

    @Override
    public String toString() {
        return "This is G object";
    }
}

class H extends G {

    public H() {
        super(0);
    }

    public H(int value) {
        super(value);
    }

    public H(int value, String string) {
        super(value, string);
    }

    @Override
    public String toString() {
        return "This is H object";
    }
}



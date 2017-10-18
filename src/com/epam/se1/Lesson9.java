package com.epam.se1;

public class Lesson9 {

    private int value;
    private double doubleValue;

    private static Integer staticMethod() {
        return 0;
    }

    private Integer method(Lesson9 this) {
        System.out.println(value);
        return value;
    }


    private static void overloading() {
        B object = new C();

        C objectCReference = (C)object;

        ((C)object).method("123");

        C objectC = new C();
        objectC.method(1);
        objectC.method();
        objectC.method("123");


        Math.abs((short)1);
    }

    public static void main(String[] args) {
//        overloading();
//        overloadingTroubles();

        Point3D point3D = new Point3D(1, 2, 3);
        System.out.println(point3D.getZ());



        Point3D.validate(1);

    }

    private static void overloadingTroubles() {
        Num num = new Num();

        Mathematica mathematica1 = new Mathematica(num);
        Mathematica mathematica2 = new Mathematica(new Int());

        Num num1 = new BigInt(1);
        Int num2 = new BigInt(2);
        Mathematica mathematica3 = new Mathematica(new BigInt(3));
        Mathematica mathematica4 = new Mathematica(num2);
        Mathematica mathematica5 = new Mathematica(num1);


//        Mathematica mathematica6 = new Mathematica(new Num(), new Num());
        Mathematica mathematica7 = new Mathematica(new BigInt(2), new BigInt(1));
        Mathematica mathematica8 = new Mathematica(new Num(), new Int());
//        Mathematica mathematica9 = new Mathematica(new Int(), new Num());
        Mathematica mathematica10 = new Mathematica(new BigInt(1), new Int());
        Mathematica mathematica11 = new Mathematica(new Int(), new BigInt(1));
    }
}

class Mathematica {
    Mathematica(Num val) {}
    Mathematica(Int val) {}
    Mathematica(Num val1, Int val2) {}
    Mathematica(Int val1, Int val2) {
        System.out.println(val1.vvalue);
        System.out.println(val2.vvalue);
    }
}

class Num {}
class Int extends Num { public int vvalue; }
class PreBigInt extends Int {}
class BigInt extends PreBigInt {

    private final int value;

    BigInt(int value) {
        this.value = value;
    }
}

class B {

    public void method() {
        System.out.println("Hello");
    }

    public void method(int value) {

    }
}

class C extends B {

    public void method(String string) {

    }

    @Override
    public void method() {
        System.out.println("World");
    }
}

class D extends B {

}

class Point2D {
    private final int x;
    private final int y;

    Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Point2D(int size) {
        this(size, size);
        System.out.println(this.x);
    }

    Point2D() {
        this(0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class Point3D extends Point2D {
    private static int counter;
    private final int z;

    Point3D(int x, int y, int z) {
        super(validate(x), y);
        System.out.println(getX());
        System.out.println(getY());
        this.z = z;
        counter++;
    }

    public static int validate(int value) {
        if (value < 0) {
            throw new IllegalArgumentException();
        }
        return value;
    }

    public int getZ() {
        return z;
    }
}
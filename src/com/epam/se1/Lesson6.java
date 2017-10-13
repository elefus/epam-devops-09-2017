package com.epam.se1;

import static java.lang.Math.*;

public class Lesson6 {

    {
        System.out.println("Logical block1");
    }

    {
        System.out.println("Logical block2");
    }

    {
        System.out.println("Logical block3");
    }

    {
        System.out.println("Logical block4");
    }

    public static void main(String[] args) {
//        integerCache();
//        castToWrapperExample();
//        arrayStoreExceptionExample();
//        negateValue();
//        testIncrementDecrement();
//        instanceOfExample();
//        ternaryOperator();
//        unaryOperation();
//        staticImportExample();
//        forExample();
//        switchExample();
//        primitvesToString();
    }

    private static void primitvesToString() {
        int a = 10;
        String str = a + "";
        String str2 = String.valueOf(a);
        String str3 = Integer.toString(a);
        String str4 = Integer.valueOf(a).toString();
        String str5 = new Integer(10).toString();

        String str6 = 10 + 5 + ""; // 15
        System.out.println(str6);

        String str7 = "" + (10 + 5); // 15
        String str8 = "" + 10 + 5; // 105
        System.out.println(str7);

        Object object = new Object();
        String str9 = "abc" + object;
        System.out.println(str9);
    }

    private static void switchExample() {
        int value = 10;
        int otherValue = -1;
        switch (value) {
            case 5:
            case 6:
            case 7:
            case 8: {
                int inCaseValue = 200;
                System.out.println("Value from 5 to 8");
                System.out.println(otherValue);
                break;
            }

            case 10:
//                inCaseValue = 300;
                System.out.println("Value 10");
                System.out.println(otherValue);
//                System.out.println(inCaseValue);
                break;

            case 15:
                System.out.println("Value 15");

            default:
                System.out.println("Other value");
        }
        System.out.println("After switch");
    }

    private static void forExample() {
//        for (int i = 0; i < 10; ++i, someMethod()) {
//        }

        label: for (int j = 0; j < 100; j++) {
            for (int i = 0; i < 10; i++) {
                if (i == 2) {
                    break label;
                }
                if (i == 1) {
                    continue label;
                }
                System.out.println(i);
            }
        }
        System.out.println("after for");

        label2: if (true) {

        }

        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                i++;
            }
        }
    }

    private static Object someMethod() {
        return null;
    }

    private static void staticImportExample() {
        Lesson6.ternaryOperator();

        abs(10);
        cos(12);
        sin(12);
        signum(100);
    }

    public void nonStatic() {

    }

    private static void unaryOperation() {
        int val = ~(10 + 10);

    }

    private static void ternaryOperator() {
        String val = 5 == 7 ? "wtf" : "success";
    }

    private static void instanceOfExample() {
        Number val = 10;
        if (val instanceof Object) {
            System.out.println("Val is object");
        }
        if (val instanceof Number) {
            System.out.println("Val is number");
        }
        if (val instanceof Integer) {
            System.out.println("Val is integer");
        }
        if (val instanceof Long) {
            System.out.println("Val is long");
        }
    }

    private static void negateValue() {
        int positiveValue = 10;
        int negativeValue = -positiveValue;
    }

    private static void castToWrapperExample() {
        short shortValue = 5;
        Integer refIntegerValue = 5;
        Short refShortValue = refIntegerValue.shortValue();
    }

    private static void arrayStoreExceptionExample() {
        Number[] numbers = new Integer[100];
        numbers[0] = 10;
//        numbers[1] = 20d;  <- ArrayStoreException
    }

    private static void testIncrementDecrement() {
        int positiveValue = 10;
        System.out.println(++positiveValue);
        // positiveValue == 11

        System.out.println(positiveValue);


        positiveValue = 10;
        System.out.println(positiveValue++);
        // positiveValue == 11
        System.out.println(positiveValue);


        int i = 0;

        ++i;
        i++;

        while (i < 10) {
//            System.out.println(i);
            i++;
        }

        bitOperations();


        boolean trueValue = someFunction();
        boolean falseValue = anotherFunction();

        if (trueValue || falseValue) {

        }
        if (someFunction() || anotherFunction()) {
            System.out.println("1");
        }

        if (someFunction() | anotherFunction()) {
            System.out.println("2");
        }
    }

    private static boolean anotherFunction() {
        // ......
        return false;
    }

    private static boolean someFunction() {
        // .....
        return true;
    }

    private static void bitOperations() {
        System.out.println("Bit operations: ");
        int a = 10;     // 0b00000....001010
        int b = 6;      // 0b00000....000110

        int or = a | b; // 0b00000....001110
        System.out.println(or);

        int and = a & b; // 0b00000....000010
        System.out.println(and);

        int negate = ~a; // 0b11111....110101
        System.out.println(negate);

        int xor = a ^ b; // 0b00000....001100
        System.out.println(xor);

        int shiftLeft = a << 1; // 0b00000....010100
        System.out.println(shiftLeft);

        int shiftRight = a >> 1; // 0b00000....000101
        System.out.println(shiftRight);

        int negativeValue = -6;
        int shiftRightNegative = negativeValue >> 1;
        System.out.println(shiftRightNegative);

        int shiftRightNegativeWithSign = negativeValue >>> 1;
        System.out.println(shiftRightNegativeWithSign);
    }

    public static int predIncrement(int value) {
        int tmp = value;
        tmp += 1;
        value = tmp;
        return value;
    }

    public static int postIncrement(int value) {
        int tmp = value;
        value += 1;
        return tmp;
    }




    public static void integerCache() {
        // int[] cache = new int[-128...127];

        Integer a = 127;
        Integer b = 127;
        System.out.println(a == b);

        a = 128;
        b = 128;
        System.out.println(a == b);

        System.out.println(a.equals(b));
    }
}

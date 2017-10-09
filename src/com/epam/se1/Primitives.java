package com.epam.se1;

public class Primitives {


    private static int b = 100;

    public static void main(String[] args) {
        int a;
        if (5 > 6) {
            a = 10;
        } else {
            a = 100;
        }

        System.out.println(a);


        System.out.println(b);


//        long bigLong = 10000000000000000000000000000000000000L;
//        int bigInt = 2_500_000_000;
        short bigShort = (short) 32_768;
        System.out.println(bigShort);

        System.out.println(Short.MAX_VALUE);

        short result = 10_000 + 10;

        result += 1;
        result = (short)(result + 1);

        result -= 1;
        result *= 1;
        result /= 1;
        result %= 1;
    }


    public static void anotherMethod() {
//        System.out.println(a);
        MyClass ref1 = new MyClass();
        MyClass ref2 = new MyClass();
        MyClass ref3 = new MyClass();
    }



}


// 8 * 2 байт
// 4 байта
// 8 байт
// 8 байт (ссылка)
// Padding (дополнили до кратности 8) = 4 байта
// Итого: 40 байт
class MyClass {

    static int staticField;
    int nonStaticField;
    double doubleVal;
    String someString;

    void method() {

    }

    void staticMethod() {

    }

}









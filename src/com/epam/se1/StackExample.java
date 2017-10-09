package com.epam.se1;

public class StackExample extends Object {

    private static Integer field;

    public StackExample() {
        System.out.println("123");
    }

    public StackExample(int a) {
        System.out.println(a);
    }

    public static void main(String...args) {
        // <- [ main | object ]

        StackExample object = new StackExample(1);

        object.anotherMethod();

        // будет ли удален val?

        // Беззнаковый char (16 бит)
        // 00000000 00000000 - минимальное значение
        // 11111111 11111111 - максимальное значение

        // 11111111 11111111 (2) = 65535 (10)
        // 1 * 2 ^ 0 = 1
        // 1 * 2 ^ 1 = 2
        // 1 * 2 ^ 2 = 4
        // 1 * 2 ^ 3 = 8
        // ...
        // 1 * 2 ^ 15 = ...


        //  9 (10) = 1001 (2)
        // 9 % 2 = 1
        // 4 % 2 = 0
        // 2 % 2 = 0
        // 1 % 2 = 1


        // 9 (10) = 11 (8)
        // 9 % 8 = 1
        // 1 % 8 = 1

        // Знаковый байт (8 бит)
        // 0....... - положительное число
        // 1....... - отрицательно число


        // 00000000 - положительный ноль
        // 10000000 - отрицательный ноль

        // N - положительное
        // Для перевода его в отрицательное
        // (!N) + 1


        // Пример
        // 00001001
        // 111  10110 <- !N
        // 11110111 <- (!N) + 1


        // OR
        // 0 | 0 = 0
        // 1 | 0 = 1
        // 0 | 1 = 1
        // 1 | 1 = 1

        // AND
        // 0 & 0 = 0
        // 1 & 0 = 0
        // 0 & 1 = 0
        // 1 & 1 = 1

        // NOT
        // ~0 = 1
        // ~1 = 0

        // XOR
        // 0 ^ 0 = 0
        // 1 ^ 0 = 1
        // 0 ^ 1 = 1
        // 1 ^ 1 = 0


        double val1 = 1d /2;
        double val2 = 0.25 * 2;
        if (Math.abs(val1 - val2) < 0.000001) {

        }

//        int intValue = main("");
    }

    public void anotherMethod() {
        // [ anotherMethod | val, a, b ]
        // [ main | object ]
        Integer val = new Integer(10);
        double a  = 100;
        long b = 200;

        Integer[] arr = new Integer[1_000_000];
        for (int i = 0; i < 1_000_000; i++) {
            arr[i] = new Integer(100);
        }


        String str = new String("abcde");
        Object obj = (Object)str;
        Integer strLength = (Integer)obj;

        System.out.println(strLength);
        // StackOverflowError
//        anotherMethod();
    }
}

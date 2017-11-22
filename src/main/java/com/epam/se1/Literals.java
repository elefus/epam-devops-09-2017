package com.epam.se1;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Literals {

    public static void main(String[] args) {
        //
        System.out.println(2_100_000_000);  // <- parse as int literal
        System.out.println(2_300_000_000L); // <- parse as long literal
        System.out.println(02_300_000_000L); // <- parse as octal long literal
        System.out.println(0xFFEEFF); // <- parse as hex int
        System.out.println(0b010101010111L); // <- parse as binary long

        // floating-point
        System.out.println(123.3333); // <- parse as double
        System.out.println(123.3333f); // <- parse as float
        System.out.println(123.3333e5); // <- parse as double
        System.out.println(12333330); // <- parse as double
        System.out.println(123.3333e-3); // <- parse as double
        System.out.println(0.1233333); // <- parse as double

        System.out.println(0xFF323e10);

        char sym = 'a';
        System.out.println('/');
        System.out.println('☺');
        System.out.println('\u263A');
        System.out.println('\'');
        System.out.println("abcd\"sdsd");
        System.out.println("abcd\\sdsd");
        System.out.println("\\d+");

        System.out.println(System.lineSeparator());

        short a = 32700;
        short b = 2000;
        short c = (short) (a + b);

        int intValue = 10;
        short d = 0;
        d += intValue;
        d = (short) (d + intValue);


        Integer integerValue = new Integer(10);
        integerValue += 10;
        integerValue++;

        Integer otherValue = new Integer(integerValue + 10);
        System.out.println();

        BigDecimal decimal = new BigDecimal(1000, new MathContext(10, RoundingMode.FLOOR));

        Integer z = new Integer(1000);

        z++;

        int tmp = z.intValue();
        tmp++;
        z = new Integer(tmp);

        int zz = z.intValue();

    }
}

package com.epam.se3.lesson21;

import java.util.Calendar;
import java.util.Locale;

public class FormatterExample {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.printf(Locale.CANADA_FRENCH, "%tB %<tA%n", calendar);
        System.out.printf(Locale.FRANCE, "%tB %<tA%n", calendar);
        System.out.printf("%tB %<tA%n", calendar);
        System.out.printf(Locale.US, "%tB %<tA%n", calendar);
        System.out.printf(Locale.UK, "%tB %<tA%n", calendar);
        System.out.printf(Locale.ENGLISH, "%tB %<tA%n", calendar);
    }
}

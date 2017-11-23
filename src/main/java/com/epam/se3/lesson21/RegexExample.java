package com.epam.se3.lesson21;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile(" (\\d+) ");
        // Initial state -> !' ' -> Initial state
        // Initial state -> ' ' -> Waiting number
        // Waiting number -> ' ' -> Waiting number
        // Waiting number -> 'a' -> Initial state
        // Waiting num1ber -> '\d' ->
        Matcher matcher = pattern.matcher("abc 123 qwerty 789 ");
        if (matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
        }
        System.out.println(matcher.start());

        matcher.reset();
        if (matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
        }
        System.out.println(matcher.start());
    }
}

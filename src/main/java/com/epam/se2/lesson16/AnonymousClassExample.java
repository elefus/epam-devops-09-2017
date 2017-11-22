package com.epam.se2.lesson16;

import java.util.Comparator;
import java.util.Date;

public class AnonymousClassExample {

    public static void main(String[] args) {
        Date x = new Date() {
            @Override
            public String toString() {
                return "Now: " + super.toString();
            }
        };
        System.out.println(x);

        x = new Date();
        System.out.println(x);

        NotAnonymous notAnonymous = new NotAnonymous() {
            @Override
            public void print() {
                System.out.println("I'm here");
            }
        };

        Comparator<String> stringComparator = new StringComparator();
        Comparator<String> anonymousStringComparator = new Comparator<String>() {


            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
    }
}

class NotAnonymous {

    public void print() {
        System.out.println("I'm not anonymous");
    }

}

class ImHereClass extends NotAnonymous {
    @Override
    public void print() {
        System.out.println("I'm here");
    }
}

class StringComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}
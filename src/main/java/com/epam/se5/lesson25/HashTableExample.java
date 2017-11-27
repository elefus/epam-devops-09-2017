package com.epam.se5.lesson25;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

public class HashTableExample {

    public static void main(String[] args) {
        Hashtable<String, String> table = new Hashtable<>();
        table.put("1", "One");
        table.put("2", "Two");
        table.put("3", "Three");
//        table.put("5", "One");

        Collection<String> values = table.values();
        System.out.println(values.getClass());
        Iterator itr = values.iterator();
        while (itr.hasNext()) {
            if (itr.next().equals("One")) {
                itr.remove();
            }
//            System.out.println(itr.next());
        }
//        values.remove("One");

        System.out.println(table);


        System.out.println("--- After ---");

        Enumeration e = table.elements();
        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }

    }
}

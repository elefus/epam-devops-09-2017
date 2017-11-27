package com.epam.se5.lesson25;

import java.util.Enumeration;
import java.util.Vector;

public class VectorExample {

    public static void main(String[] args) {
        Vector<Number> vector = new Vector<>(3, 2);
        System.out.println("Initial size: " + vector.size());
        System.out.println("Initial capacity: " + vector.capacity());
        vector.addElement(1);
        vector.addElement(2);
        vector.addElement(3);
        vector.addElement(4);
        System.out.println("Capacity after four additions: " + vector.capacity());
        vector.addElement(5.45);
        System.out.println("Current capacity: " + vector.capacity());

        Enumeration vEnum = vector.elements();
        System.out.println("\nElements in vector:");
        while (vEnum.hasMoreElements())
            System.out.print(vEnum.nextElement() + " ");
        System.out.println();

    }
}

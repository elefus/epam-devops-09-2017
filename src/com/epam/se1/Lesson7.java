package com.epam.se1;

public class Lesson7 {

    public static void main(String[] args) {
        stringToPrimitives();
    }

    private static void stringToPrimitives() {
        String intValue = "123";
        int a = Integer.valueOf(intValue);
        System.out.println(a);

        int valueInHex = Integer.valueOf(intValue, 16);
        System.out.println(valueInHex);

        String wrongIntValue = "123ab";
        try {
            int wrongValue = Integer.valueOf(wrongIntValue);
        } catch (NumberFormatException ex) {
            System.out.println(ex + " - is not a valid number");
        }
    }
}





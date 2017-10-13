package com.epam.se1;

public class Semaphore {

    // 0 - 3   Зеленый
    // 4 - 5   Желтый
    // 6 - 9   Красный
    // 10 - 13 Зеленый
    // ...
    public static void main(String[] args) {
        Integer value = Integer.parseInt(args[0]);
        value %= 10;

        if (value >= 0 && value <= 3) {
            System.out.println("Green");
        } else if (value >= 4 && value <= 5) {
            System.out.println("Yellow");
        } else  {
            System.out.println("Red");
        }
    }
}

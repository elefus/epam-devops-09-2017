package com.epam.kotov;

public class Semaphore {

    // 0 - 3
    // 4 - 5
    // 6 - 9
    // 10 - 13

    public static void main(String[] args) {
        int currentTime = Integer.parseInt(args[0]);

        int interval = currentTime % 10;

        switch (interval) {
            case 0:
            case 1:
            case 2:
            case 3:
                System.out.println("Green");
                break;
            case 4:
            case 5:
                System.out.println("Yellow");
                break;
            default:
                System.out.println("Red");
        }

    }

}

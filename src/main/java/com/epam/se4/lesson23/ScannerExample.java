package com.epam.se4.lesson23;

import java.io.IOException;
import java.util.Scanner;

public class ScannerExample {

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            scanner.useDelimiter("_");

            System.out.println(scanner.next());
            System.out.println(scanner.next());
        }
        System.in.read();
    }
}

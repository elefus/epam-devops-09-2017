package com.epam.se1;

public class MainClass {

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

        for (String arg : args) {
            System.out.println(arg);
        }

        String string = "123";
        for (char c : string.toCharArray()) {

        }

        PackageVisible packageVisible = new PackageVisible();
    }
}

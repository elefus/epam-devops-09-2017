package com.epam.se3.lesson21;

import java.io.InputStream;
import java.util.Locale;
import java.util.ResourceBundle;

public class PropertiesResourceBundleExample {

    public static void main(String[] args) {
        System.out.println(Locale.getDefault());

        ResourceBundle ruRuResourceBundle = ResourceBundle.getBundle("strings");
        System.out.println(ruRuResourceBundle.getString("key1"));

        ResourceBundle enUsResourceBundle = ResourceBundle.getBundle("strings", Locale.US);
        System.out.println(enUsResourceBundle.getString("key1"));

        ResourceBundle enResourceBundle = ResourceBundle.getBundle("strings", Locale.ENGLISH);
        System.out.println(enResourceBundle.getString("key1"));

        Locale.setDefault(Locale.FRANCE);
        ResourceBundle frResourceBundle = ResourceBundle.getBundle("strings");
        System.out.println(frResourceBundle.getString("key1"));

        ResourceBundle ruByResourceBundle = ResourceBundle.getBundle("strings", new Locale("com", "BY"));
        System.out.println(ruByResourceBundle.getString("key1"));

        ResourceBundle testBundle = ResourceBundle.getBundle("com.epam.se3.lesson21.test");
        System.out.println(testBundle.getString("key"));
        InputStream inputTest = PropertiesResourceBundleExample.class.getResourceAsStream("test.properties");
        InputStream inputStrings = PropertiesResourceBundleExample.class.getResourceAsStream("./../../../../strings.properties");
        System.out.println();
    }
}

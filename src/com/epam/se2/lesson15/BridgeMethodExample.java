package com.epam.se2.lesson15;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class BridgeMethodExample implements Comparable<BridgeMethodExample> {

    public static void main(String[] args) {
        BridgeMethodExample bridgeMethodExample = new BridgeMethodExample();
        Class<? extends BridgeMethodExample> clazz = bridgeMethodExample.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            System.out.println(method);
            System.out.println(method.isBridge());
            System.out.println(method.isSynthetic());
        }

        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            System.out.println(constructor);
            System.out.println(constructor.isSynthetic());
        }
    }

    @Override
    public int compareTo(BridgeMethodExample other) {
        return 0;
    }
}

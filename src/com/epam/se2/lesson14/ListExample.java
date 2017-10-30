package com.epam.se2.lesson14;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ListExample {

    public static void main(String[] args) {
        A object = new A(10);
        Class<A> aClass = (Class<A>) object.getClass();
        try {
            Field field = aClass.getDeclaredField("value");
            field.setAccessible(true);

            field.set(object, 300);
            Object value = field.get(object);
            System.out.println(value);

            Constructor<A> constructor = aClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            A a = constructor.newInstance();
            System.out.println(a);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        System.out.println(object.getValue());

        System.out.println(aClass.getName());


//        ObjectList<Integer> intList = new ObjectList();
//        intList.add("123");
//        intList.add(1).add(1).add(10).add(30);
//        intList.add(2);
//        intList.add(10);
//        Integer intValue = (Integer) intList.get(0);
//
//        ObjectList doubleList = new ObjectList();
//        doubleList.add(10.5);
//        doubleList.add(15.5);
//        doubleList.add(18.5);
//        doubleList.add(120.5);
    }
}

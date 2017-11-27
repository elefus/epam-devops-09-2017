package com.epam.se5.lesson25;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class ReferencesExample {

    public static void main(String[] args) {
        MyClass object = new MyClass();
        SoftReference<MyClass> softReference = new SoftReference<>(object);

        object = null;
        MyClass dereference = softReference.get();
        softReference.clear();

        WeakReference<MyClass> weakReference = new WeakReference<>(dereference);
        weakReference.clear();
        weakReference.isEnqueued();

        ReferenceQueue<MyClass> queue = new ReferenceQueue<>();
        PhantomReference<MyClass> phantomReference = new PhantomReference<>(dereference, queue);

        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        integers.removeIf(value -> value > 2);
        integers.forEach(value -> System.out.print(value * 2 + " "));

        Object[] objects = integers.toArray();
        Number[] values = integers.toArray(new Number[0]);
        System.out.println(Arrays.toString(values));
    }


}


class MyClass {

}
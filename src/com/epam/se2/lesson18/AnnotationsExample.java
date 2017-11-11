package com.epam.se2.lesson18;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@OneParameterAnnotation("class")
public class AnnotationsExample {

    /**
     * Значение.
     */
    @SuppressWarnings({"unused", "all", "qwert"})
    @MyAnnotation(age = 200, name = "123")
    @OneParameterAnnotation("23")
    private int value = 10;

    @OneParameterAnnotation("anno")
    public void method() {

    }

    public static void main(String[] args) throws Exception {
        Field value = AnnotationsExample.class.getDeclaredField("value");
        for (Annotation annotation : value.getDeclaredAnnotations()) {
            System.out.println(annotation);
        }


        System.out.println("Method annotation: ");
        Method method = Child.class.getDeclaredMethod("method");
        System.out.println(method);
        System.out.println(method.getAnnotation(OneParameterAnnotation.class));

        System.out.println("Class annotation: ");
        System.out.println(Child.class.getAnnotation(OneParameterAnnotation.class));
    }
}

class Child extends AnnotationsExample {

    @Override
    public void method() {
    }
}

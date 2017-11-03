package com.epam.se2.lesson16;

import java.io.Serializable;

public class InheritanceInnerClassExample {

    private int value = 10;
    protected static int value2 = 20;

    private class InnerParent implements Serializable {

    }

    class InnerChild extends InnerParent {

        public int childValue = 42;

        public int getValue() {
            System.out.println(value2);
            return value;
        }
    }
}

class OuterClass extends InheritanceInnerClassExample.InnerChild {

    public OuterClass(InheritanceInnerClassExample ref) {
        ref.super();
    }
}

class Launcher {

    public static void main(String[] args) {
        InheritanceInnerClassExample outer = new InheritanceInnerClassExample();
        InheritanceInnerClassExample.InnerChild innerChild1 = outer.new InnerChild();
        InheritanceInnerClassExample.InnerChild innerChild2 = outer.new InnerChild();
    }
}
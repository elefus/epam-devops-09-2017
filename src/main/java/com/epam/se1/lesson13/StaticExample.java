package com.epam.se1.lesson13;

public class StaticExample {

    public static void main(String[] args) {
//        Doctor.staticMethodInMan();
//        Doctor doctor = new Doctor();
//        System.out.println(Doctor.form);
//        Doctor.staticMethodInDoctor();
        Doctor doctor = new Doctor();
        doctor.info();
        doctor.printValue("11");
        Doctor.staticMethod();
        doctor.staticMethod();

        Man man = new Doctor();
        man.info();
        man.printValue(1);
        Man.staticMethod();
        man.staticMethod();

        Surgeon surgeon = new Surgeon();
        surgeon.staticMethod();
    }
}

class Man {

    public static final String form = "man";

    static {
        System.out.println("Static block in man");
    }

    public static void staticMethod() {
        System.out.println("Static method in man");
    }

    public void info() {
        System.out.println("I'm man");
    }

    public void printValue(int value) {
        System.out.println(value);
    }
}


class Doctor extends Man {

    static {
        System.out.println("Static block in doctor");
    }

    public static void staticMethod() {
        Man.staticMethod();
        System.out.println("Static method in doctor");
    }

    @Override
    public void info() {
        super.info();
        System.out.println("I'm also doctor");
    }

    public void printValue(String value) {
        System.out.println(value);
    }
}

class Surgeon extends Doctor {

}
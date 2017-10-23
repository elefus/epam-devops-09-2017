package com.epam.se1;

import java.util.Arrays;

public class Lesson11 {

}

class Person implements Cloneable {

    public static Person zombie;
    private final String name;
    private final String surname;
    private final String patronymic;
    private String[] numbers;

    public Person(Person other) {
        name = other.name;
        surname = other.surname;
        patronymic = other.patronymic;
        numbers = Arrays.copyOf(other.numbers, other.numbers.length);
    }

    public Person(String name, String surname, String patronymic, String[] numbers) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.numbers = numbers;
    }

    Person(String name, String surname, String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;

    }

    @Override
    public int hashCode() {
        int sum = name.hashCode();
        sum = sum * 31 + surname.hashCode();
        sum = sum * 31 + patronymic.hashCode();
        return sum;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != Person.class) {
            return false;
        }
        Person other = (Person)obj;
        return other.name.equals(name)
                && other.surname.equals(surname)
                && other.patronymic.equals(patronymic);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        zombie = this;
    }

    @Override
    public Person clone() {
        try {
            Person result = (Person) super.clone();
            result.numbers = Arrays.copyOf(numbers, numbers.length);
            return result;
        } catch (CloneNotSupportedException ex) {
            throw new Error(ex);
        }
    }

    public String[] getNumbers() {
        return numbers;
    }
}


class E {

    public static void main(String[] args) {
        varargs(1, 2);
        anArray(1, 2, new int[0]);
    }

    public static void varargs(int a, int b, int...other) {
    }

    public static void anArray(int a, int b, int[] other) {

    }

    public Number getNumber() {
        return null;
    }

}

class F extends E {

    @Override
    public Integer getNumber() {
        return 1;
    }
}
package com.epam.se1;

import com.epam.se1.Person;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest1 {

    @Test
    void shouldBeEqual() {
        Person person1 = new Person("a", "a", "a");
        Person person2 = new Person("a", "a", "a");
        Person person3 = new Person("a", "a", "a");

        assertTrue(person1.equals(person1));
        assertTrue(person1.equals(person2));
        assertTrue(person2.equals(person1));
        assertTrue(person2.equals(person3));
        assertTrue(person1.equals(person3));
        assertTrue(person3.equals(person1));
    }

    @Test
    void shouldBeNotEqual() {
        Person person1 = new Person("a", "a", "a");
        Person person2 = new Person("a", "a", "a");

        assertTrue(person1.equals(person2));
        assertEquals(person1.hashCode(), person2.hashCode());
    }

    // -2^31             2^31 - 1
    //   [ | | | | |*| | ]
    //              |
    //            [person1, "+7-950-333-33-33"]
    //
    //


    @Test
    void failedWithHashMap() {
        Person person1 = new Person("a", "a", "a");
        Person person2 = new Person("a", "a", "a");

        HashMap<Person, String> hashTable = new HashMap<>();
        hashTable.put(person1, "+7-950-333-33-33");

        // 1_239_548_589


        assertEquals("+7-950-333-33-33", hashTable.get(person2));
    }

    @Test
    void testHashCode() {
        Person person1 = new Person("a", "a", "a");
        Person person2 = new Person("b", "a", "a");

        assertFalse(person1.equals(person2));
        assertFalse(person1.equals(null));
        assertFalse(person2.equals(null));
    }

    @Test
    void toStringTest() {
        Person person = new Person("a", "b", "c");
        assertEquals("Person{name='a', surname='b', patronymic='c'}", person.toString());
    }

    @Test
    void cloneTest() {
        Person person1 = new Person("a", "b", "c");
        Person person2 = person1.clone();
        assertNotSame(person1, person2);
        assertEquals(person1, person2);
    }

    @Test
    void deepCloneTest() {
        String[] number = {"81200000", "81211111", "81222222"};
        Person person1 = new Person("a", "b", "c", number);
        Person person2 = person1.clone();
        assertNotSame(person1, person2);
        assertEquals(person1, person2);

        person2.getNumbers()[0] = "qqqq";
        assertNotSame(person1.getNumbers(), person2.getNumbers());
        assertEquals("qqqq", person2.getNumbers()[0]);
        assertEquals("81200000", person1.getNumbers()[0]);
    }
}
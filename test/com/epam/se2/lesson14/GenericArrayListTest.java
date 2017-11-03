package com.epam.se2.lesson14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericArrayListTest {
    @Test
    void add() {
        GenericArrayList<Integer> list = new GenericArrayList<>();
        list.add(10);

        assertEquals(new Integer[]{1}, list.toArray());
    }

    @Test
    void add1() {
    }

    @Test
    void set() {
    }

}
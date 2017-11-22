package com.epam.se1;

import com.epam.se1.Lesson12;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lesson12Test {

    @Test
    void testZeroValue() {
        assertEquals("0", Lesson12.createStringFromZeroTo(0));
    }

    @Test
    void testFromZeroToOne() {
        assertEquals("0 1", Lesson12.createStringFromZeroTo(1));
    }

    @Test
    void testFromZeroToFive() {
        assertEquals("0 1 2 3 4 5", Lesson12.createStringFromZeroTo(Integer.MAX_VALUE));
    }
}
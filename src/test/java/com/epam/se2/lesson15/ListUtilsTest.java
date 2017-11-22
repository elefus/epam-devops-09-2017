package com.epam.se2.lesson15;

import com.epam.se2.lesson15.ListUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListUtilsTest {
    @Test
    void fill() {
        List<Integer> integers = new ArrayList<>();
        List<Number> numbers = new ArrayList<>();
        List<Object> objects = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        ListUtils.fill(integers, 10);
        ListUtils.fill(numbers, 10);
        ListUtils.fill(objects, 10);

        assertEquals(Arrays.asList(10, 10, 10), integers);
    }

    @Test
    void createArrayList() {
        Collection<Integer> integers = Arrays.asList(1, 2, 3);
        ArrayList<Number> numbers = new ArrayList<>(integers);
    }

}
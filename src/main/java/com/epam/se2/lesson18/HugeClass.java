package com.epam.se2.lesson18;

import lombok.*;

// Plain
// Old
// Java
// Object
@AllArgsConstructor
public class HugeClass {

    @Getter
    @Setter
    private int value1;

    @Getter
    private int value2;
    private int value3;
    private int value4;
    private int value5;
    private int value6;
    private int value7;
    private int value8;
    private int value9;
    private int value10;

    public int getValue10() {
        return value10;
    }
}

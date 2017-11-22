package com.epam.se2.lesson15;

import java.io.Serializable;

public class NumberUtils {

    public <T extends Number & Serializable> Number sum(T left, T right) {
        return left.doubleValue() + right.doubleValue();
    }

//    public Number sum(Number left, Number right) {
//        return left.doubleValue() + right.doubleValue();
//    }


}

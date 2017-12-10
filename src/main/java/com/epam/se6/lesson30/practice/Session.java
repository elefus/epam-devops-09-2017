package com.epam.se6.lesson30.practice;

public interface Session {

    Object getValue(String name);
    void setValue(String name, Object value);
}

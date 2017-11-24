package com.epam.se4.lesson24;

import java.io.*;

class NotSerializable {
    private int fieldA = 10;
    private double fieldB = 10.5;

    public NotSerializable() {
    }

    public NotSerializable(int fieldA, double fieldB) {
        this.fieldA = fieldA;
        this.fieldB = fieldB;
    }

    public int getFieldA() {
        return fieldA;
    }

    public double getFieldB() {
        return fieldB;
    }
}

class A extends NotSerializable implements Serializable {
    private String string;
    transient private NotSerializable field = new NotSerializable(50, 50.5);

    public A() {super(20, 20.5);}

    public A(String string) {
        super(30, 30.5);
        this.string = string;
    }

    public String getString() {
        return string;
    }
}

class B extends A {

}

class C extends B {
    private B b;
}

public class SerializationExample {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        simpleSerializationExample();
        String string = "hello";
        A value1 = new A(string);
        A value2 = new A(string);
        A value3 = value1;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(value1);
        objectOutputStream.writeObject(value2);
        objectOutputStream.writeObject(value3);

        ByteArrayInputStream is = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(is);
        A deserializedA1 = (A) ois.readObject();
        if (deserializedA1 instanceof A) {
            System.out.println("I'm object A-class");
        } else {
            throw new IllegalStateException();
        }
        A deserializedA2 = (A)ois.readObject();
        A deserializedA3 = (A)ois.readObject();
        System.out.println(deserializedA1 == deserializedA2);
        System.out.println(deserializedA1 == deserializedA3);
        System.out.println(deserializedA1.getString() == deserializedA3.getString());
        System.out.println(deserializedA1.getString() == deserializedA2.getString());
        System.out.println(deserializedA1.getFieldA());
        System.out.println(deserializedA1.getFieldB());
    }

    private static void simpleSerializationExample() throws IOException, ClassNotFoundException {
        Object objSave = new C();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(objSave);

        // смотрим, во что превратился сериализованный объект
        byte[] bArray = byteArrayOutputStream.toByteArray();
        for (byte b : bArray) {
            System.out.print((char) b);
        }
        System.out.println();

        // десериализация
        ByteArrayInputStream is = new ByteArrayInputStream(bArray);
        ObjectInputStream ois = new ObjectInputStream(is);
        Object objRead = ois.readObject();
        // проверяем идентичность объектов
        System.out.println("readed object is: " + objRead.toString());
        System.out.println("Object equality is: " + (objSave.equals(objRead)));
        System.out.println("Reference equality is: " + (objSave == objRead));
    }
}

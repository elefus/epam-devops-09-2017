package com.epam.se4.lesson24;

import java.io.*;

public class SerialIdExample {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        serialize();
        deserialize();
    }

    private static void deserialize() throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.tmp"))) {
            Object obj = in.readObject();
            System.out.println(obj);
        }
    }

    private static void serialize() throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.tmp"))) {
            out.writeObject(new E());
        }
    }
}

class E implements Serializable {
    private static final long serialVersionUID = 2L;
    private int field2 = 43;
    private int field3= 44;

    @Override
    public String toString() {
        return "E{" +
                ", field2=" + field2 +
                ", field3=" + field3 +
                '}';
    }
}
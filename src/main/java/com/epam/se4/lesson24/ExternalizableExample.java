package com.epam.se4.lesson24;

import java.io.*;

public class ExternalizableExample {

    public static final String FOBJECT_TMP = "FObject.tmp";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serialize();
        deserialize();
    }

    private static void serialize() throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FOBJECT_TMP))) {
            out.writeObject(new F());
        }
    }

    private static void deserialize() throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FOBJECT_TMP))) {
            Object obj = in.readObject();
            System.out.println(obj);
        }
    }
}

class F implements Externalizable {
    private String string = "str";
    private int intField = 42;

    public F() {
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(intField);
        out.writeObject(string);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        intField = in.readInt();
        string = (String) in.readObject();
    }

    @Override
    public String toString() {
        return "F{" +
                "string='" + string + '\'' +
                ", intField=" + intField +
                '}';
    }
}

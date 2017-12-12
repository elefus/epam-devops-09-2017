package com.epam.se7.lesson32.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;

public class JAXBWriterExample {

    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Student.class);
            Marshaller marshaller = context.createMarshaller();
            Student.Address address = new Student.Address("BLR", "Minsk","Skoriny 4");
            Student student = new Student("mendig", "Dmitry Terenya", "rfe", 2066394, address);
            marshaller.marshal(student, new FileOutputStream("stud.xml"));
            marshaller.marshal(student, System.out);
            System.out.println("XML-файл создан");
        } catch (FileNotFoundException ex) {
            System.out.println("XML-файл не найден");
            ex.printStackTrace();
        } catch (JAXBException ex) {
            System.out.println("JAXB-исключения");
            ex.printStackTrace();
        }
    }
}

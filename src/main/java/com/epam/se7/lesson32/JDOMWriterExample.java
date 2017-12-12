package com.epam.se7.lesson32;

import com.epam.se7.lesson31.Address;
import com.epam.se7.lesson31.Student;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JDOMWriterExample {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("login_1", "Иванов ", "МОЭВМ", 330212,
                            new Address("Россия", "Санкт-Петербург", "Певческий пер. 25")),
                new Student("login_2", "Иванов ", "МОЭВМ", 330212,
                            new Address("Россия", "Санкт-Петербург", "Октябрьская ул. 119")),
                new Student("login_3", "Иванов ", "МОЭВМ", 330212,
                            new Address("Россия", "Санкт-Петербург", "Коломяжский пр. 34"))
        );
        Element studentsElement = create(students);
        boolean savedSuccessfully = saveDocument("students_new.xml", new Document(studentsElement));
        System.out.println(savedSuccessfully ? "Документ создан" : "Документ НЕ создан");
    }

    private static Element create(List<Student> list) {
        Element students = new Element("students");
        for (Student student : list) {
            students.addContent(convertToXml(student));
        }
        return students;
    }

    private static Element convertToXml(Student student) {
        Element faculty = new Element("faculty").setText(student.getFaculty());
        Element name = new Element("name").setText(student.getName());
        return new Element("student").setAttribute("login", student.getLogin())
                                     .setAttribute("phone", String.valueOf(student.getTelephone()))
                                     .addContent(faculty)
                                     .addContent(name)
                                     .addContent(convertToXml(student.getAddress()));
    }

    private static Element convertToXml(Address address) {
        Element country = new Element("country").setText(address.getCountry());
        Element city = new Element("city").setText(address.getCity());
        Element street = new Element("street").setText(address.getStreet());
        return new Element("address").addContent(country).addContent(city).addContent(street);
    }

    private static boolean saveDocument(String fileName, Document doc) {
        try {
            new XMLOutputter().output(doc, new FileOutputStream(fileName));
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}

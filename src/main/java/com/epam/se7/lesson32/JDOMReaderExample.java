package com.epam.se7.lesson32;

import com.epam.se7.lesson31.Address;
import com.epam.se7.lesson31.Student;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class JDOMReaderExample {

    public static void main(String[] args) throws Exception {
        SAXBuilder parser = new SAXBuilder();
        Document document = parser.build("students.xml");

        List<Student> students = extractStudents(document.getRootElement());
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static List<Student> extractStudents(Element root) {
        List<Element> studentElements = root.getChildren("student");
        ArrayList<Student> students = new ArrayList<>(studentElements.size());

        for (Element studentElement : studentElements) {
            Element addressElement = studentElement.getChild("address");
            Address address = new Address(addressElement.getChild("country").getText(),
                                          addressElement.getChild("city").getText(),
                                          addressElement.getChild("street").getText());

            Student student = new Student(studentElement.getAttributeValue("login"),
                                          studentElement.getChild("name").getText(),
                                          studentElement.getAttributeValue("faculty"),
                                          Integer.valueOf(studentElement.getChild("telephone").getText()),
                                          address);
            students.add(student);
        }
        return students;
    }

    private static Stream<Student> extractStudentsUsingStreams(Element root) {
        return root.getChildren("student")
                   .stream()
                   .map(JDOMReaderExample::extractStudent);
    }

    private static Student extractStudent(Element student) {
        return new Student(student.getAttributeValue("login"),
                           student.getChild("name").getText(),
                           student.getAttributeValue("faculty"),
                           Integer.valueOf(student.getChild("telephone").getText()),
                           extractAddress(student.getChild("address")));
    }

    private static Address extractAddress(Element address) {
        return new Address(address.getChild("country").getText(),
                           address.getChild("city").getText(),
                           address.getChild("street").getText());
    }
}

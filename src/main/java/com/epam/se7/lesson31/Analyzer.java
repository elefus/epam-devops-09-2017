package com.epam.se7.lesson31;

import java.util.ArrayList;
import java.io.IOException;
import org.xml.sax.SAXException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Analyzer {

    public static ArrayList<Student> listBuilder(Element root) throws SAXException, IOException {
        ArrayList<Student> students = new ArrayList<>();
        NodeList studentsNodes = root.getElementsByTagName("student");
        Student student;
        for (int i = 0; i < studentsNodes.getLength(); i++) {
            student = new Student();
            Element studentElement = (Element) studentsNodes.item(i);
            // заполнение объекта student

            student.setFaculty(studentElement.getAttribute("faculty"));
            student.setName(getChildValue(studentElement, "name"));
            student.setLogin(studentElement.getAttribute("login"));
            int tel = Integer.valueOf(getChildValue(studentElement, "telephone"));
            student.setTelephone(tel);
            Address address = student.getAddress();
            // заполнение объекта address
            Element addressElement = getChild(studentElement, "address");
            address.setCountry(getChildValue(addressElement, "country"));
            address.setCity(getChildValue(addressElement, "city"));
            address.setStreet(getChildValue(addressElement, "street"));
            students.add(student);
        }// конец цикла for
        return students;
    }
    // возвращает дочерний элемент по его имени и родительскому элементу
    private static Element getChild(Element parent, String childName) {
        return (Element) parent.getElementsByTagName(childName).item(0);
    }
    // возвращает текст, содержащийся в элементе
    private static String getChildValue(Element parent, String childName) {
        Element child = getChild(parent, childName);
        Node node = child.getFirstChild();
        String value = node.getNodeValue();
        return value;
    }
}


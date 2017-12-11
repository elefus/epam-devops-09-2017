package com.epam.se7.lesson31;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.InputStream;

class StAXExample {

    public static void main(String[] args) throws Exception {
        StAXStudentsParser parser = new StAXStudentsParser();
        // создание входного потока данных из xml-файла
        InputStream input = new FileInputStream("students.xml");
        // разбор файла с выводом результата на консоль
        parser.parse(input);
    }

}

public class StAXStudentsParser {

    public void parse(InputStream input) {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try {
            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
            process(reader);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    // метод, управляющий разбором потока
    private void process(XMLStreamReader reader) throws XMLStreamException {
        String name;
        while (reader.hasNext()) {
            // определение типа "прочтённого" элемента (тега)
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    writeStudentFeature(name);
                    StudentsEnum enumName = StudentsEnum.valueOf(name.toUpperCase());
                    studentInfoHandle(enumName, reader);
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    break;
                case XMLStreamConstants.CHARACTERS:
                    writeText(reader.getText());
                    break;
            }
        }
    }

    private void studentInfoHandle(StudentsEnum enumName,
                                   XMLStreamReader reader) {
        switch (enumName) {
            case STUDENTS:
                this.writeTitle();
                break;
            case STUDENT: {
                String login = reader.getAttributeValue(null, StudentsEnum.LOGIN
                        .name().toLowerCase());
                String faculty = reader.getAttributeValue(null,
                        StudentsEnum.FACULTY.name().toLowerCase());
                writeStudent(login, faculty);
            }
            break;
            case ADDRESS:
                writeAddress();
                break;
        }
    }

    public void writeTitle() {
        System.out.println("Students:");
    }

    public void writeStudent(String... args) {
        System.out.println("Student: Login: " + args[0] + " Faculty: " + args[1]);
    }

    public void writeAddress() {
        System.out.println(" Address: ");
    }

    public void writeStudentFeature(String name) {
        switch (StudentsEnum.valueOf(name.toUpperCase())) {
            case STREET:
                System.out.print(" Street: ");
                break;
            case CITY:
                System.out.print(" City: ");
                break;
            case COUNTRY:
                System.out.print("Country: ");
                break;
            case TELEPHONE:
                System.out.print(" Telephone: ");
                break;
            case NAME:
                System.out.print("Name: ");
                break;
        }
    }

    public void writeText(String text) {
        System.out.println(text.trim());
    }
}

enum StudentsEnum {
    STREET,
    CITY,
    COUNTRY,
    TELEPHONE,
    NAME,
    STUDENTS,
    STUDENT,
    ADDRESS,
    LOGIN,
    FACULTY
}

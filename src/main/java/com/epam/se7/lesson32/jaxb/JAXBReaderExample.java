package com.epam.se7.lesson32.jaxb;

import javax.xml.bind.*;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JAXBReaderExample {

    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Student.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(new FileReader("stud.xml"));
            JAXBElement<Student> unmarshal1 = unmarshaller.unmarshal(reader, Student.class);
            Student unmarshal = unmarshal1.getValue();
            System.out.println(unmarshal);
            System.out.println("XML-файл создан");
        } catch (JAXBException ex) {
            System.out.println("JAXB-исключения");
            ex.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}

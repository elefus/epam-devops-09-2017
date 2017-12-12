package com.epam.se7.lesson32.validation;

import org.xml.sax.SAXException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XSDValidation {

    public static void main(String[] args) throws IOException {
        try {
            SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            File schemaLocation = new File("students.xsd");
            Schema schema = factory.newSchema(schemaLocation);

            Validator validator = schema.newValidator();
            Source source = new StreamSource("students.xml");
            validator.validate(source);
            System.out.println("File successfully validate.");
        } catch (SAXException ex) {
            System.out.println("File is not valid because of " + ex.getMessage());
        }
    }
}

package com.epam.se7.lesson31;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;

public class ListSAXExample extends DefaultHandler {

    HashMap nameToClass;
    HashMap nameToPatterns;
    StringBuffer accumulator;
    String servletName, servletClass, servletPattern;

    public void startDocument() {
        accumulator = new StringBuffer();
        nameToClass = new HashMap();
        nameToPatterns = new HashMap();
    }

    public void characters(char[] buffer, int start, int length) {
        accumulator.append(buffer, start, length);
    }
    public void startElement(String namespaceURL, String localName, String qname, Attributes attributes) {
        accumulator.setLength(0);
    }

    public void endElement(String namespaceURL, String localName, String qname) {
        if (localName.equals("servlet-name")) { // Store servlet name
            servletName = accumulator.toString().trim();
        } else if (localName.equals("servlet-class")) { // Store servlet class
            servletClass = accumulator.toString().trim();
        } else if (localName.equals("url-pattern")) { // Store servlet pattern
            servletPattern = accumulator.toString().trim();
        } else if (localName.equals("servlet")) { // Map name to class
            nameToClass.put(servletName, servletClass);
        } else if (localName.equals("servlet-mapping")) {// Map name to pattern
            List patterns = (List) nameToPatterns.get(servletName);
            if (patterns == null) {
                patterns = new ArrayList();
                nameToPatterns.put(servletName, patterns);
            }
            patterns.add(servletPattern);
        }
    }
    public void endDocument() {
        List servletNames = new ArrayList(nameToClass.keySet());
        Collections.sort(servletNames);
        for (Object servletName1 : servletNames) {
            String name = (String) servletName1;
            String classname = (String) nameToClass.get(name);
            List patterns = (List) nameToPatterns.get(name);
            System.out.println("Servlet: " + name);
            System.out.println("Class: " + classname);
            if (patterns != null) {
                System.out.println("Patterns:");
                for (Object pattern : patterns) {
                    System.out.println("\t" + pattern);
                }
            }
            System.out.println();
        }
    }

    public void warning(SAXParseException exception) {
        System.err.println("WARNING: line " + exception.getLineNumber() + ": "
                + exception.getMessage());
    }

    public void error(SAXParseException exception) {
        System.err.println("ERROR: line " + exception.getLineNumber() + ": "
                + exception.getMessage());
    }

    public void fatalError(SAXParseException exception) throws SAXException {
        System.err.println("FATAL: line " + exception.getLineNumber() + ": "
                + exception.getMessage());
        throw (exception);
    }
}

package com.epam.se7.lesson31;

import org.xml.sax.Attributes;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxParserExample {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setValidating(false);
        SAXParser sp = spf.newSAXParser();
        sp.parse(new File("web.xml"), new WebXmlHandler());
    }

}

class WebXmlHandler extends DefaultHandler implements ErrorHandler {

    StringBuffer accumulator = new StringBuffer();
    String servletName;
    String servletClass;
    String servletId;

    public void startDocument() throws SAXException {
        System.out.println("parsing started");
    }

    public void endDocument() throws SAXException {
        System.out.println("Parsing ended");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        accumulator.setLength(0);
        if (qName.equals("servlet")) {
            servletId = attributes.getValue("id");
        }
    }
    public void characters(char[] buffer, int start, int length) {
        accumulator.append(buffer, start, length);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("servlet-name")) {
            servletName = accumulator.toString().trim();
        } else if (qName.equals("servlet-class")) {
            servletClass = accumulator.toString().trim();
        } else if (qName.equals("servlet")) {
            System.out.println("Servlet " + servletName
                    + ((servletId != null) ? " (id=" + servletId + ")" : "")
                    + ": " + servletClass);
        }
    }

    public void warning(SAXParseException exception) {
        System.err.println("WARNING: line " + exception.getLineNumber() + ": " + exception.getMessage());
    }

    public void error(SAXParseException exception) {
        System.err.println("ERROR: line " + exception.getLineNumber() + ": " + exception.getMessage());
    }

    public void fatalError(SAXParseException exception) throws SAXException {
        System.err.println("FATAL: line " + exception.getLineNumber() + ": " + exception.getMessage());
        throw exception;
    }
}

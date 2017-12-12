package com.epam.se7.lesson32.jaxb;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.*;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Student", propOrder = { "name", "telephone", "address" })
// задание последовательности элементов XML
public class Student {
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    private String login;
    @XmlElement(required = true)
    private String name;
    @XmlAttribute(required = true)
    private String faculty;
    @XmlElement(required = true)
    private int telephone;
    @XmlElement(required = true)
    private Address address = new Address();
    public Student() {
    }// необходим для генерации XML

    public Student(String login, String name, String faculty, int telephone,
                   Address address) {
        this.login = login;
        this.name = name;
        this.faculty = faculty;
        this.telephone = telephone;
        this.address = address;
    }
    public String getLogin() {	return login;	}
    public void setLogin(String login) {	this.login = login;	}
    public String getName() {	return name;	}
    public void setName(String name) {	this.name = name;	}
    public String getFaculty() {	return faculty;	}
    public void setFaculty(String faculty) {	this.faculty = faculty;}
    public int getTelephone() {	return telephone;	}
    public void setTelephone(int telephone) {	this.telephone = telephone;}
    public Address getAddress() {	return address;}
    public void setAddress(Address address) {	this.address = address;}
    public String toString() {
        return "\nLogin: " + login + "\nName: " + name + "\nTelephone: " + telephone + "\nFaculty: " + faculty + address.toString();
    }

    @XmlRootElement
    public static class Address {// внутренний класс
        private String country;
        private String city;
        private String street;
        public Address() {
        }
        public Address(String country, String city, String street) {
            this.country = country;
            this.city = city;
            this.street = street;
        }
        public String getCountry() {	return country;	}
        public void setCountry(String country) {this.country = country;}
        public String getCity() {	return city;}
        public void setCity(String city) {this.city = city;	}
        public String getStreet() {	return street;	}
        public void setStreet(String street) {this.street = street;}
        public String toString() {
            return "\nAddress:" + "\n\tCountry: " + country + "\n\tCity: "+ city + "\n\tStreet: " + street + "\n";
        }
    }
}

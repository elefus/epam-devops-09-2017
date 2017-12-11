package com.epam.se7.lesson31;

public class Student {
    private String login;
    private String name;
    private String faculty;
    private int telephone;
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
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFaculty() {
        return faculty;
    }
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
    public int getTelephone() {
        return telephone;
    }
    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    public String toString() {
        return "\nLogin: " + login + "\nName: " + name + "\nTelephone: " + telephone + "\nFaculty: " + faculty + address.toString();
    }
}

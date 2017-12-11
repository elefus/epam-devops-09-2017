package com.epam.se7.lesson31;

public class Address {// внутренний класс
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
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String toString() {
        return "\nAddress:" + "\n\tCountry: " + country + "\n\tCity: " + city + "\n\tStreet: " + street + "\n";
    }
}

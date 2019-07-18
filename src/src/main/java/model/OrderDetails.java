package model;

import java.util.Objects;

public class OrderDetails {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String street;
    private String country;
    private String city;
    private String phoneNumber;

    public OrderDetails(String name, String lastName, String email,
                 String street, String country, String city,
                 String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.street = street;
        this.country = country;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetails orderDetails = (OrderDetails) o;
        return  Objects.equals(name, orderDetails.name) &&
                Objects.equals(lastName, orderDetails.lastName) &&
                Objects.equals(email, orderDetails.email) &&
                Objects.equals(street, orderDetails.street) &&
                Objects.equals(country, orderDetails.country) &&
                Objects.equals(city, orderDetails.city) &&
                Objects.equals(phoneNumber, orderDetails.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, email, street, country, city, phoneNumber);
    }

    @Override
    public String toString() {
        return "Order\n" +
                ", name=" + name + '\n' +
                ", lastName=" + lastName + '\n' +
                ", email=" + email + '\n' +
                ", street=" + street + '\n' +
                ", country=" + country + '\n' +
                 ", city=" + city + '\n' +
                ", phoneNumber=" + phoneNumber + '\n';
    }
}

package com.perezma.stream.model;

import java.util.Objects;

public class Customer {

    private String name;
    private String city;
    private int startDate;

    public Customer() {
    }

    public Customer(String name, String city, int startDate) {
        this.name = name;
        this.city = city;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return startDate == customer.startDate
                && Objects.equals(name, customer.name)
                && Objects.equals(city, customer.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city, startDate);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}

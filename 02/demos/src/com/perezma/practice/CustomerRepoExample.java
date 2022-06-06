package com.perezma.practice;

import com.perezma.stream.model.Customer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * This class expands use of the Predicate functional interface by using a more real-world example.
 *
 * https://mkyong.com/java8/java-8-predicate-examples/
 */
public class CustomerRepoExample {

    public static void main(String[] args) {

        Customer c1 = new Customer("Mike","Houston",20220601);
        Customer c2 = new Customer("John","Bellaire",20220101);
        Customer c3 = new Customer("Fred","Cypress",20220201);
        Customer c4 = new Customer("Steve","Woodlands",20220301);
        Customer c5 = new Customer("Beto","Tomball",20220401);
        Customer c6 = new Customer("Charles","Galveston",20220501);
        Customer c7 = new Customer("Ben","Pasadena",20220415);
        Customer c8 = new Customer("Fred","Katy",20220316);
        Customer c9 = new Customer("Nick","Sugar Land",20220222);
        Customer c10 = new Customer("Tom","Houston",20220111);

        List<Customer> customers = Arrays.asList(new Customer[]{c1,c2,c3,c4,c5,c6,c7,c8,c9,c10});

        Predicate<Customer> houstonCusts = customer -> customer.getCity().equals("Houston");

        Predicate<Customer> lastThirtyDays = customer -> customer.getStartDate() >= 20220501;

        List<Customer> onlyHouston = CustomerRepository.filterCustomers(customers,houstonCusts);

        List<Customer> newCusts = CustomerRepository.filterCustomers(customers, lastThirtyDays);

        System.out.println("onlyHouston : " + onlyHouston);

        System.out.println("newCusts : " + newCusts);

    }
}

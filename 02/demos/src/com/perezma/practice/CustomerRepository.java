package com.perezma.practice;

import com.perezma.stream.model.Customer;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomerRepository {

    public static List<Customer> filterCustomers(List<Customer> customers, Predicate<Customer> predicate) {
        return customers.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}

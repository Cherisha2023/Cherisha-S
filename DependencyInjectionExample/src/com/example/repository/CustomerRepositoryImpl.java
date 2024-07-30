// src/com/example/repository/CustomerRepositoryImpl.java
package com.example.repository;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private Map<Integer, String> customers = new HashMap<>();

    public CustomerRepositoryImpl() {
        customers.put(1, "John Doe");
        customers.put(2, "Jane Smith");
        customers.put(3, "Michael Johnson");
        customers.put(4, "Lady Andal");
        customers.put(5, "Robert Jefferson");
        customers.put(6, "Herbert Williams");
        customers.put(7, "Emma Johnson");
    }

    @Override
    public String findCustomerById(int id) {
        return customers.getOrDefault(id, "Customer not found");
    }
}

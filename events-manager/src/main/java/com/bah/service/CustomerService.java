package com.bah.service;

import com.bah.domain.Customer;
import com.bah.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerService {
    @Autowired
    private CustomerRepository repo;

    public Iterable<Customer> findAllCustomers() {
        return repo.findAll();
    }
}

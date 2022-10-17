package com.bah.service;

import com.bah.domain.Customer;
import com.bah.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

//    @Override
//    public Customer findByName() {
//        return null;
//    }

    public Optional<Customer> findByName(String name) {
        return customerRepository.findByName(name);
    }
}

package com.bah.service;

import com.bah.domain.Customer;
import com.bah.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface CustomerService {

    Iterable<Customer> findAll();

    Optional<Customer> findByName(String name);
}

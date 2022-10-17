package com.bah.api;

import com.bah.domain.Customer;
import com.bah.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerApi {
    ArrayList<Customer> customerList = new ArrayList<Customer>();


    public CustomerApi() {
        Customer customer1 = new Customer(1, "Carlos", "carlos@bah.com", "12345");
        Customer customer2 = new Customer(1, "Samer", "samer@bah.com", "12345");
        Customer customer3 = new Customer(1, "Ahmed", "ahmed@bah.com", "12345");

        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);
    }

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping
    public Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping("/{customername}")
    public boolean searchForName(@RequestBody Customer customer, @PathVariable String customerName){
        Optional<Customer> customerOptional = customerRepository.findByName(customerName);

        if (customerOptional.isPresent()){
            return true;
        }

        return false;
    }

    @GetMapping("/{customerName}")
    public Optional<Customer> findByName(@PathVariable("customerName") String customerName){
        return customerRepository.findByName(customerName);
    }

    @GetMapping("/{customerId}")
    public Optional<Customer> findById(@PathVariable("customerId") long id){
        return customerRepository.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestBody Customer newCustomer, UriComponentsBuilder uri){

        if(newCustomer.getId() !=0 || newCustomer.getName() == null || newCustomer.getEmail() == null){
            return ResponseEntity.badRequest().build();
        }
        newCustomer = customerRepository.save(newCustomer);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newCustomer.getId()).toUri();
        ResponseEntity<?> response = ResponseEntity.created(location).build();
        return response;
    }

    @PostMapping("/{customerId}")
    public ResponseEntity<?> updateCustomerByid(@RequestBody Customer newCustomer, @PathVariable("customerId") long customerId){

        if(newCustomer.getId() !=0 || newCustomer.getName() == null || newCustomer.getEmail() == null){
            return ResponseEntity.badRequest().build();
        }
        newCustomer = customerRepository.save(newCustomer);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{customerName}")
    public ResponseEntity<?> updateCustomerByName(@RequestBody Customer newCustomer, @PathVariable("customerName") String customerName){

        if(newCustomer.getId() !=0 || newCustomer.getName() == null || newCustomer.getEmail() == null){
            return ResponseEntity.badRequest().build();
        }
        newCustomer = customerRepository.save(newCustomer);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public  ResponseEntity<?> deleteCustomerById(@RequestBody Customer deleteCustomer, @PathVariable long id){
        if(deleteCustomer.getId() !=0 || deleteCustomer.getName() == null || deleteCustomer.getEmail() == null){
            return ResponseEntity.badRequest().build();
        }
        customerRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{customerName}")
    public  ResponseEntity<?> deleteCustomerByName(@RequestBody Customer deleteCustomer, @PathVariable long id){
        if(deleteCustomer.getId() !=0 || deleteCustomer.getName() == null || deleteCustomer.getEmail() == null){
            return ResponseEntity.badRequest().build();
        }
        customerRepository.delete(deleteCustomer);
        return ResponseEntity.ok().build();
    }
}
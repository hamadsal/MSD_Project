package com.bah;

import com.bah.domain.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	Customer customer1 = new Customer(1, "Carlos", "carlos@bah.com", "12345");
	Customer customer2 = new Customer(1, "Samer", "samer@bah.com", "12345");
	Customer customer3 = new Customer(1, "Ahmed", "ahmed@bah.com", "12345");

}

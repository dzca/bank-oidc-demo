package com.eazybytes.controller;

import com.eazybytes.model.Customer;
import com.eazybytes.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.saveCustomer(customer);
        return ResponseEntity.ok(savedCustomer);
    }
}

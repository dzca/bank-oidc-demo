package com.eazybytes.service;

import com.eazybytes.model.Authority;
import com.eazybytes.model.Customer;
import com.eazybytes.repository.AuthorityRepository;
import com.eazybytes.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;
    private AuthorityRepository authorityRepository;

    // save by reference
    public Customer saveCustomer(Customer customer) {
        if (customer.getAuthorities() != null) {
            Set<Authority> existingAuthorities = customer.getAuthorities().stream()
                    .map(authority -> authorityRepository.findById(authority.getId())
                            .orElseThrow(() -> new RuntimeException("Authority not found: " + authority.getId())))
                    .collect(Collectors.toSet());
            customer.setAuthorities(existingAuthorities);
        }
        return customerRepository.save(customer);
    }

//    public Customer saveCustomer(Customer customer) {
//        // Save authorities first and ensure unique IDs
//        if (customer.getAuthorities() != null) {
//            customer.setAuthorities(
//                    customer.getAuthorities().stream()
//                            .map(authorityRepository::save)
//                            .collect(Collectors.toSet())
//            );
//        }
//        // Save customer
//        return customerRepository.save(customer);
//    }
}
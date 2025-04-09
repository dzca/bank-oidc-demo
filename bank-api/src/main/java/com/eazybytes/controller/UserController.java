package com.eazybytes.controller;

import com.eazybytes.model.Customer;
import com.eazybytes.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class UserController {

    private final CustomerRepository customerRepository;
//    private final PasswordEncoder passwordEncoder;

//    @PostMapping("/authority")
//    public ResponseEntity<String> registerUser(@RequestBody Authority authority) {
//        try {
//
//            String hashPwd = passwordEncoder.encode(customer.getPwd());
//            customer.setPwd(hashPwd);
//            Customer savedCustomer = customerRepository.save(customer);
//
//            if(!savedCustomer.getId().isEmpty()) {
//                return ResponseEntity.status(HttpStatus.CREATED).
//                        body("Given user details are successfully registered");
//            } else {
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).
//                        body("User registration failed");
//            }
//        } catch (Exception ex) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
//                    body("An exception occurred: " + ex.getMessage());
//        }
//
//    }

//    @PostMapping("/register")
//    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
//        try {
//
//                String hashPwd = passwordEncoder.encode(customer.getPwd());
//                customer.setPwd(hashPwd);
//                Customer savedCustomer = customerRepository.save(customer);
//
//                if(!savedCustomer.getId().isEmpty()) {
//                    return ResponseEntity.status(HttpStatus.CREATED).
//                            body("Given user details are successfully registered");
//                } else {
//                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).
//                            body("User registration failed");
//                }
//        } catch (Exception ex) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
//                    body("An exception occurred: " + ex.getMessage());
//        }
//
//    }

//    curl -X GET http://localhost:6001/user \
//            -H "Authorization: Basic $(echo -n 'username:password' | base64)" \
//            -H "Content-Type: application/json"
    @RequestMapping("/user")
    public Customer getUserDetailsAfterLogin(Authentication authentication) {
        Optional<Customer> optionalCustomer = customerRepository.findByEmail(authentication.getName());
        return optionalCustomer.orElse(null);
    }
}

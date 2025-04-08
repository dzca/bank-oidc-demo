package com.eazybytes.model;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "customer")
@Data
@Builder
@Slf4j
public class Customer {

    @Id
    private String id;
    private String email;
    private String pwd;
    private String role;
}

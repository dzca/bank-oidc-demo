package com.eazybytes.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "authorities")
public class Authority {
    @Id
    private String id;

    private String name;

//    @DBRef
//    private Customer customer;
}

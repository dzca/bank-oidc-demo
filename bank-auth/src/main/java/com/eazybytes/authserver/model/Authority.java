package com.eazybytes.authserver.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "authorities")
public class Authority {
    @Id
    private long id;

    private String name;

    @DBRef
    private Customer customer;
}

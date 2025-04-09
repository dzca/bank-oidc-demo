package com.eazybytes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;
import java.util.Set;


@Document(collection = "customers")
@Data
public class Customer {

    @Id
    private String id;

    private String name;

    private String email;
    private String mobileNumber;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String pwd;

    private String role;

    @JsonIgnore
    private Date createDt;

    @DBRef
    private Set<Authority> authorities;
}

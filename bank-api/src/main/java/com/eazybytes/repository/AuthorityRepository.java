package com.eazybytes.repository;

import com.eazybytes.model.Authority;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends MongoRepository<Authority,String> {
}

package com.uruttu.akshaya_server.repository;

import com.uruttu.akshaya_server.model.CustomerModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerModel,String> {
}

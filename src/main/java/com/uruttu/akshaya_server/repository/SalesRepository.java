package com.uruttu.akshaya_server.repository;

import com.uruttu.akshaya_server.model.SalesModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SalesRepository extends MongoRepository<SalesModel,String> {
}

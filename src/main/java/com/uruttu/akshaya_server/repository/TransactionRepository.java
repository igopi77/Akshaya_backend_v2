package com.uruttu.akshaya_server.repository;

import com.uruttu.akshaya_server.model.TransactionModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<TransactionModel,String> {
}

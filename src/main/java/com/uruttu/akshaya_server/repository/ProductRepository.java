package com.uruttu.akshaya_server.repository;

import com.uruttu.akshaya_server.model.ProductModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductModel,Long> {
}

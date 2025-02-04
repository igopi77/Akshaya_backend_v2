package com.uruttu.akshaya_server.repository;

import com.uruttu.akshaya_server.model.ProductModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<ProductModel,String> {
}

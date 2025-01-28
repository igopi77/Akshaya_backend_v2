package com.uruttu.akshaya_server.service;


import com.uruttu.akshaya_server.model.ProductModel;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface ProductService {
    ResponseEntity<ProductModel> addProduct(ProductModel productModel);
}

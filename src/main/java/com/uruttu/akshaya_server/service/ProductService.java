package com.uruttu.akshaya_server.service;


import com.uruttu.akshaya_server.model.ProductModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface ProductService {
    List<ProductModel> addProduct(List<ProductModel> productModel);
    ResponseEntity<Map<String,Object>> getProduct();
    ResponseEntity<Map<String,Object>> getProductIds();
    ResponseEntity<Map<String,Object>> updateProductById(ProductModel productModel);
}

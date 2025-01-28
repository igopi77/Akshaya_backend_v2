package com.uruttu.akshaya_server.service.impl;


import com.uruttu.akshaya_server.controller.ProductController;
import com.uruttu.akshaya_server.model.ProductModel;
import com.uruttu.akshaya_server.repository.ProductRepository;
import com.uruttu.akshaya_server.response.BaseResponse;
import com.uruttu.akshaya_server.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;


    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);



    @Override
    public ResponseEntity<ProductModel> addProduct(ProductModel productModel) {
        logger.info("productModel : " + productModel);
        ProductModel savedOne = productRepository.save(productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOne);
    }

}

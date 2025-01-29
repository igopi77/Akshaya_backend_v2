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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;


    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);



    @Override
    public List<ProductModel> addProduct(List<ProductModel> productModel) {
        logger.info("productModel : " + productModel);
        return productRepository.saveAll(productModel);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getProduct() {
        Map<String, Object> response = new HashMap<>();
        try  {
            List<ProductModel> productList = productRepository.findAll();
            response.put("products", productList);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            response.put("error",e);
            return ResponseEntity.status(500).body(response);
        }
    }

    @Override
    public ResponseEntity<Map<String, Object>> getProductIds() {
        Map<String,Object> response = new HashMap<>();

        try {
            List<ProductModel> productModels = productRepository.findAll();
            if (productModels.isEmpty()) {
                response.put("message", "No product Id's found");
                return ResponseEntity.status(300).body(response);
            }
            List<String> productId = productModels.stream().map(ProductModel::getId).toList();
            response.put("productId", productId);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            response.put("error",e);
            return ResponseEntity.status(300).body(response);
        }
    }

}

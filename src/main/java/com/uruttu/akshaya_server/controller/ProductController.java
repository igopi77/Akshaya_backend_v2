package com.uruttu.akshaya_server.controller;


import com.uruttu.akshaya_server.helper.Urls;
import com.uruttu.akshaya_server.model.ProductModel;
import com.uruttu.akshaya_server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = Urls.PRODUCT)
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = Urls.ADD_PRODUCT)
    ResponseEntity<ProductModel> addProduct(@RequestBody ProductModel productModel) {
        System.out.println("productModel sending : " + productModel);
        return productService.addProduct(productModel);
    }


}

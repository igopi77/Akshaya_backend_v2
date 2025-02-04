package com.uruttu.akshaya_server.controller;


import com.uruttu.akshaya_server.dto.ProductDTO;
import com.uruttu.akshaya_server.dto.SalesDTO;
import com.uruttu.akshaya_server.helper.Urls;
import com.uruttu.akshaya_server.model.ProductModel;
import com.uruttu.akshaya_server.model.SalesModel;
import com.uruttu.akshaya_server.response.DashboardResponse;
import com.uruttu.akshaya_server.service.ProductService;
import com.uruttu.akshaya_server.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = Urls.PRODUCT)
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private SalesService salesService;

    @PostMapping(value = Urls.ADD_PRODUCT)
    ResponseEntity<String> addProduct(@RequestBody ProductDTO productDTO) {
        if (productDTO == null || productDTO.getProductDTO() == null) {
            return ResponseEntity.badRequest().body("Error: Received NULL request body");
        }
        System.out.println("productModel sending : " + productDTO.getProductDTO());
        List<ProductModel> productModels = productService.addProduct(productDTO.getProductDTO());
        if (!productModels.isEmpty()) {
            return ResponseEntity.ok().body("Added successfully");
        }
        return ResponseEntity.status(500).body("Failed to add products");
    }

    @PostMapping(value = Urls.ADD_SALES)
    ResponseEntity<Map<String,Object>> addSales(@RequestBody SalesDTO salesDTO) {
        return salesService.addSalesForProduct(salesDTO.getSales());
    }

    @GetMapping(value = Urls.GET_PRODUCT)
    ResponseEntity<Map<String,Object>> getProduct() {
        return productService.getProduct();
    }

    @GetMapping(value = Urls.GET_ALL_PRODUCT_ID)
    ResponseEntity<Map<String,Object>> getAllProductId() {
        return productService.getProductIds();
    }

    @GetMapping(value = Urls.DASHBOARD)
    ResponseEntity<DashboardResponse> getDashboard() {
       return salesService.getDashboardResponse();
    }

}

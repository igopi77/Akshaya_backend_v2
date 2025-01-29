package com.uruttu.akshaya_server.service.impl;

import com.uruttu.akshaya_server.model.ProductModel;
import com.uruttu.akshaya_server.model.SalesModel;
import com.uruttu.akshaya_server.repository.ProductRepository;
import com.uruttu.akshaya_server.repository.SalesRepository;
import com.uruttu.akshaya_server.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SalesServiceImpl implements SalesService {
    private final SalesRepository salesRepository;
    private final ProductRepository productRepository;

    @Autowired
    public SalesServiceImpl(SalesRepository salesRepository,ProductRepository productRepository) {
        this.salesRepository = salesRepository;
        this.productRepository = productRepository;
    }


    @Override
    public ResponseEntity<Map<String, Object>> addSalesForProduct(List<SalesModel> salesModelList) {
        List<SalesModel> successfulSales = new ArrayList<>();
        List<Map<String, String>> failedSales = new ArrayList<>();

        for (SalesModel salesModel : salesModelList) {
            try {
                boolean isDecremented = findAndDecrementProduct(salesModel.getProductId(), salesModel.getQuantity());

                if (isDecremented) {
                    salesRepository.save(salesModel);
                    successfulSales.add(salesModel);
                } else {
                    failedSales.add(Map.of("productId", salesModel.getProductId(), "error", "Not enough stock"));
                }
            } catch (Exception e) {
                failedSales.add(Map.of("productId", salesModel.getProductId(), "error", e.getMessage()));
            }
        }

        if (!failedSales.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("message", "Some sales failed", "failedSales", failedSales, "successfulSales", successfulSales));
        }

        return ResponseEntity.ok().body(Map.of("message", "All sales processed successfully", "sales", successfulSales));
    }

    public boolean findAndDecrementProduct(String productId, int quantity) {
        Optional<ProductModel> optionalProduct = productRepository.findById(productId);

        if (optionalProduct.isEmpty()) {
            throw new RuntimeException("Product not found");
        }

        ProductModel productModel = optionalProduct.get();

        if (productModel.getQuantity() < quantity) {
            return false; // Not enough stock
        }

        productModel.setQuantity(productModel.getQuantity() - quantity);
        productRepository.save(productModel);
        return true; // Successfully decremented
    }
}

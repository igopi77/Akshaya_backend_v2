package com.uruttu.akshaya_server.service.impl;

import com.uruttu.akshaya_server.model.ProductModel;
import com.uruttu.akshaya_server.model.SalesModel;
import com.uruttu.akshaya_server.repository.ProductRepository;
import com.uruttu.akshaya_server.repository.SalesRepository;
import com.uruttu.akshaya_server.response.DashboardResponse;
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
        List<String> salesIds = new ArrayList<>();

        try {
            for (SalesModel salesModel : salesModelList) {
                try {
                    boolean isDecremented = findAndDecrementProduct(salesModel);

                    boolean isSalesProcessed = processSale(salesModel);

                    if (isDecremented && isSalesProcessed) {
                        salesRepository.save(salesModel);
                        successfulSales.add(salesModel);
                        salesIds.add(salesModel.getProductId());
                    } else {
                        failedSales.add(Map.of("productId", salesModel.getProductId(), "error", "Not enough stock"));
                    }
                } catch (Exception e) {
                    failedSales.add(Map.of("productId", salesModel.getProductId(), "error", e.getMessage()));
                }
            }

            if (!failedSales.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(Map.of("message", "Some sales failed", "failedSales", failedSales, "successfulSales", successfulSales, "generatePdfIds", salesIds, "status", true));
            }

            return ResponseEntity.ok().body(Map.of("message", "All sales processed successfully", "sales", successfulSales, "generatePdfIds", salesIds, "status", true));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("message", "e", "status", false));
        }
    }

    @Override
    public ResponseEntity<DashboardResponse> getDashboardResponse() {
        List<SalesModel> salesList = salesRepository.findAll();
        List<ProductModel> productList = productRepository.findAll();

        double totalSales = 0;
        double totalRevenue = 0;
        double totalCost = 0;
        double totalProfit = 0;
        int totalPurchases = productList.size();
        double totalPurchaseCost = 0;

        for (SalesModel sale : salesList) {
            totalSales += sale.getQuantity();
            totalRevenue += sale.getTotalAmount();
            totalCost += (sale.getTotalAmount() - sale.getProfit());
            totalProfit += sale.getProfit();
        }

        for (ProductModel product : productList) {
            totalPurchaseCost += (product.getCostPrice() * product.getQuantity());
        }

        return ResponseEntity.ok().body(new DashboardResponse(totalSales, totalRevenue, totalCost, totalProfit, totalPurchases, totalPurchaseCost,true));
    }

    public boolean processSale(SalesModel sale) {
        // Fetch the product's cost price from the database
        Optional<ProductModel> productOpt = productRepository.findById(sale.getProductId());

        if (productOpt.isPresent()) {
            ProductModel product = productOpt.get();
            double costPricePerUnit = product.getCostPrice();

            // Calculate Profit = (Selling Price - Cost Price) * Quantity
            double profit = (sale.getUnitPrice() - costPricePerUnit) * sale.getQuantity();
            sale.setProfit(profit);

            salesRepository.save(sale);
            return true;
        } else {
            System.out.println("Product not found for sale:"  + sale.getProductId());
            return false;
        }
    }

    public boolean findAndDecrementProduct(SalesModel salesModel) {
        Optional<ProductModel> optionalProduct = productRepository.findById(salesModel.getProductId());

        if (optionalProduct.isEmpty()) {
            throw new RuntimeException("Product not found");
        }

        ProductModel productModel = optionalProduct.get();

        if (productModel.getQuantity() < salesModel.getQuantity()) {
            return false; // Not enough stock
        }

        productModel.setQuantity(productModel.getQuantity() - salesModel.getQuantity());
        productRepository.save(productModel);
        return true; // Successfully decremented
    }
}

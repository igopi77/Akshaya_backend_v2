package com.uruttu.akshaya_server.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Document(collection = "products")
public class ProductModel {
    @Id
    private String id;

    private String productName;
    private int quantity;
    private String unit;
    private int costPrice;
    private int sellingPrice;
    private double discount;
    private DateTimeFormat createAt;
    private DateTimeFormat updatedAt;
}
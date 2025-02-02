package com.uruttu.akshaya_server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "products")
public class ProductModel {
    @Id
    private String id;
    private String productName;
    private int quantity;
    private String pricePerUnitForPurchase;
    private String pricePerUnitForSales;
    private double costPrice;
    private int sellingPrice;
    private double discount;
    private String dateOfSale;
    private String dateOfExpiry;
    private String createAt;
    private String updatedAt;

    private ProductModel() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPricePerUnitForPurchase(String pricePerUnitForPurchase) {
        this.pricePerUnitForPurchase = pricePerUnitForPurchase;
    }

    public void setPricePerUnitForSales(String pricePerUnitForSales) {
        this.pricePerUnitForSales = pricePerUnitForSales;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setDateOfExpiry(String dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    public void setDateOfSale(String dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    public String getDateOfExpiry() {
        return dateOfExpiry;
    }

    public String getDateOfSale() {
        return dateOfSale;
    }

    public String getId() {
        return this.id;
    }

    public String getProductName() {
        return this.productName;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String getPricePerUnitForPurchase() {
        return pricePerUnitForPurchase;
    }

    public String getPricePerUnitForSales() {
        return pricePerUnitForSales;
    }

    public double getCostPrice() {
        return this.costPrice;
    }

    public int getSellingPrice() {
        return this.sellingPrice;
    }

    public double getDiscount() {
        return this.discount;
    }

    public String getCreateAt() {
        return this.createAt;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }
}
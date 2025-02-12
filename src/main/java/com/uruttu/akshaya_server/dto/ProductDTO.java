package com.uruttu.akshaya_server.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.uruttu.akshaya_server.model.ProductModel;

import java.util.List;

public class ProductDTO {

    @JsonProperty("products")
    private List<ProductModel> products;

    @JsonProperty("updated_product")
    private ProductModel productModel;

    private ProductDTO() {}

    public List<ProductModel> getProductDTO() {
        return products;
    }

    public void setProductDTO(List<ProductModel> productDTO) {
        this.products = productDTO;
    }


    public void setProductModel(ProductModel productModel) {
        this.productModel = productModel;
    }

    public ProductModel getProductModel() {
        return productModel;
    }
}

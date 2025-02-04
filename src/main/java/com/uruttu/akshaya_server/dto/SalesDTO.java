package com.uruttu.akshaya_server.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.uruttu.akshaya_server.model.SalesModel;

import java.util.List;

public class SalesDTO {

    @JsonProperty("sales")
    private List<SalesModel> sales;

    private SalesDTO() {}

    public List<SalesModel> getSales() {
        return sales;
    }

    public void setSales(List<SalesModel> sales) {
        this.sales = sales;
    }
}

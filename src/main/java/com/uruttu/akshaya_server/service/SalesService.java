package com.uruttu.akshaya_server.service;

import com.uruttu.akshaya_server.model.SalesModel;
import com.uruttu.akshaya_server.response.DashboardResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface SalesService {

    ResponseEntity<Map<String,Object>> addSalesForProduct(List<SalesModel> salesModelList);
    ResponseEntity<DashboardResponse> getDashboardResponse();
}

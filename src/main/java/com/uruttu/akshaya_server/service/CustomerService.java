package com.uruttu.akshaya_server.service;

import com.uruttu.akshaya_server.model.CustomerModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface CustomerService {

    ResponseEntity<Map<String,Object>> addCustomer(CustomerModel customerModel);
    ResponseEntity<Object> getCustomer();
}

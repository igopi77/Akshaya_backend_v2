package com.uruttu.akshaya_server.controller;


import com.uruttu.akshaya_server.helper.Urls;
import com.uruttu.akshaya_server.model.CustomerModel;
import com.uruttu.akshaya_server.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = Urls.CUSTOMER)
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping(value = Urls.ADD_CUSTOMER)
    ResponseEntity<Map<String,Object>> addCustomer(@RequestBody CustomerModel customerModel) {
        return customerService.addCustomer(customerModel);
    }

    @GetMapping(value = Urls.GET_CUSTOMER)
    ResponseEntity<Object> getCustomer() {
        return customerService.getCustomer();
    }
}

package com.uruttu.akshaya_server.service.impl;
import com.uruttu.akshaya_server.model.CustomerModel;
import com.uruttu.akshaya_server.repository.CustomerRepository;
import com.uruttu.akshaya_server.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public ResponseEntity<Map<String, Object>> addCustomer(CustomerModel customerModel) {
        try {
            CustomerModel customerModel1;
            customerModel1 = customerRepository.save(customerModel);
            return ResponseEntity.ok().body(Map.of("message" , "customer added successfully","id" ,customerModel1.getId(),"status",true));
        }
        catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("message" , "unable to add","status",false));
        }
    }

    @Override
    public ResponseEntity<Object> getCustomer() {
        try {
            List<CustomerModel> customerModelList = customerRepository.findAll();
            return ResponseEntity.ok().body(customerModelList);
        }
        catch (Exception e) {
            return ResponseEntity.ok().body(Map.of("message","unable to get : " + e));
        }
    }
}

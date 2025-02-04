package com.uruttu.akshaya_server.service.impl;
import com.uruttu.akshaya_server.model.CustomerModel;
import com.uruttu.akshaya_server.repository.CustomerRepository;
import com.uruttu.akshaya_server.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public ResponseEntity<Map<String, Object>> addCustomer(CustomerModel customerModel) {
        try {
            Optional<CustomerModel> customerModel1 = Optional.ofNullable(customerRepository.findByEmail(customerModel.getEmail()));
            if (customerModel1.isEmpty()) {
                CustomerModel customerModel12;
                customerModel12 = customerRepository.save(customerModel);
                return ResponseEntity.ok().body(Map.of("message", "customer added successfully", "id", customerModel12.getId(), "status", true));
            }
            return ResponseEntity.ok().body(Map.of("message", "already existed", "id", customerModel1.get().getId(), "status", true));

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

package com.uruttu.akshaya_server.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

@Data
@Document(collection = "customers")
public class CustomerModel {

    @Id
    private String id;

    private String customerName;
    private String email;
    private String phone;
    private List<Object> transactionHistory;
    private DateTimeFormat createAt;
    private DateTimeFormat updatedAt;
}

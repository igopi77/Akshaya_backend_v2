package com.uruttu.akshaya_server.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Document(collection = "transaction")
public class TransactionModel {

    @Id
    private String id;

    private String transactionId;
    private String type;
    private String amount;
    private String productId;
    private String customerId;
    private String note;
    private DateTimeFormat date;
    private DateTimeFormat createdAt;
}

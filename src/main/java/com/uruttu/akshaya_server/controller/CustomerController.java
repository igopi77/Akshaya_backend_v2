package com.uruttu.akshaya_server.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/check")
public class CustomerController {

    @GetMapping
    Map<String,String> getCustomer() {
        return Map.of("name","gopinath");
    }
}

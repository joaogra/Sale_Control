package com.example.sales_control.controllers;

import com.example.sales_control.Services.CustomerService;
import com.example.sales_control.dto.CustomerCreateDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/costumer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {this.customerService = customerService;}

    @PostMapping
    public ResponseEntity<Void> createCustomer(@Valid @RequestBody CustomerCreateDTO dto) {
        customerService.createCustomer(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }




}

package com.example.sales_control.controllers;

import com.example.sales_control.Services.CustomerService;
import com.example.sales_control.dto.customerDTOs.CustomerCreateDTO;
import com.example.sales_control.dto.customerDTOs.CustomerResponseDTO;
import com.example.sales_control.dto.customerDTOs.CustomerUpdateDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

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

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponseDTO>  getCustomer(@PathVariable UUID customerId) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getCustomer(customerId));
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Void> updateCustomer(@PathVariable UUID customerId, @RequestBody CustomerUpdateDTO dto) {
        customerService.updateCustomer(customerId, dto);
        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable UUID customerId) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }






}

package com.example.sales_control.controllers;


import com.example.sales_control.Services.ProductService;
import com.example.sales_control.Services.SaleService;
import com.example.sales_control.dto.saleDTO.SaleRequestDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sale")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {this.saleService = saleService;}

    @PostMapping
    public ResponseEntity<Void> createSale (@RequestBody @Valid SaleRequestDTO dto){
        saleService.createSale(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}

package com.example.sales_control.controllers;

import com.example.sales_control.Services.ProductService;
import com.example.sales_control.dto.productsDTOs.ProductCreateDTO;
import com.example.sales_control.dto.productsDTOs.ProductResposeDTO;
import com.example.sales_control.dto.productsDTOs.ProductUpdateDTO;
import com.example.sales_control.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {this.productService = productService;}

    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody ProductCreateDTO product) {
        productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResposeDTO> getProduct(@PathVariable Integer productId) {
        return ResponseEntity.ok(productService.getProduct(productId));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Void> updateProduct(@PathVariable Integer productId, @RequestBody ProductUpdateDTO product) {
        productService.updateProduct(productId, product);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

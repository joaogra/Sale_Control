package com.example.sales_control.Services;


import com.example.sales_control.dto.productsDTOs.ProductCreateDTO;
import com.example.sales_control.dto.productsDTOs.ProductResposeDTO;
import com.example.sales_control.dto.productsDTOs.ProductUpdateDTO;
import com.example.sales_control.model.Product;
import com.example.sales_control.repositories.ProductRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.dao.DataAccessException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {this.productRepository = productRepository;}

    public void createProduct(@NotNull @Valid ProductCreateDTO dto) {

        Product product = new Product();

        product.setProductName(dto.productName());
        product.setPrice(dto.price());

        productRepository.save(product);

    }

    public ProductResposeDTO getProduct(Integer productId) {

        Product product = productRepository.findById(productId).orElseThrow(()-> new IllegalArgumentException("Product not found"));

        return new ProductResposeDTO(
                product.getProductId(),
                product.getProductName(),
                product.getPrice()
        );

    }

    public void updateProduct(Integer productId, @NotNull @Valid ProductUpdateDTO dto) {

        Product product = productRepository.findById(productId).orElseThrow(()-> new IllegalArgumentException("Product not found"));

        if (dto.productName() != null) product.setProductName(dto.productName());
        if (dto.price() != null) product.setPrice(dto.price());

        productRepository.save(product);

    }

    public void deleteProduct(Integer productId) {

        Product product = productRepository.findById(productId).orElseThrow(()-> new IllegalArgumentException("Product not found"));

        productRepository.delete(product);

    }



}

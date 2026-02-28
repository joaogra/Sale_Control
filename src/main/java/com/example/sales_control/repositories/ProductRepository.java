package com.example.sales_control.repositories;

import com.example.sales_control.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serial;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}

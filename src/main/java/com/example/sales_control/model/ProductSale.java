package com.example.sales_control.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "product_sales")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductSale {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID product_sale_id;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    @JsonBackReference
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantity;
    private Double unPrice;
}

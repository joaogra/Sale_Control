package com.example.sales_control.dto.productsDTOs;

public record ProductResposeDTO(
        Integer productID,
        String productName,
        Double price
) {
}

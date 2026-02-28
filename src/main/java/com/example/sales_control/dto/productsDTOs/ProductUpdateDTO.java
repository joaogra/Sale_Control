package com.example.sales_control.dto.productsDTOs;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductUpdateDTO(
        String productName,
        @Min(0)
        Double price
) {
}

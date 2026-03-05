package com.example.sales_control.dto.saleDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record SaleItemsRequestDTO(
        @NotNull
        Integer productId,

        @Positive(message = "A quantidade deve ser positiva")
        Integer quantity
) {
}

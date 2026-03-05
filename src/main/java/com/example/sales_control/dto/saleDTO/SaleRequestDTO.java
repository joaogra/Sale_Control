package com.example.sales_control.dto.saleDTO;

import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record SaleRequestDTO(
        @NotNull
        UUID customerId,
        List<SaleItemsRequestDTO> items
) {
}

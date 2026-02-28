package com.example.sales_control.dto.customerDTOs;

import java.util.UUID;

public record CustomerResponseDTO(
        UUID customerID,
        String customerName,
        String email,
        String phoneNumber
) {
}

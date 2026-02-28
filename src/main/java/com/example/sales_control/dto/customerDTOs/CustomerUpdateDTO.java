package com.example.sales_control.dto.customerDTOs;

import jakarta.validation.constraints.Email;

public record CustomerUpdateDTO(
    String name,
    @Email(message = "Email inválido")
    String email,
    String phoneNumber
) {
}

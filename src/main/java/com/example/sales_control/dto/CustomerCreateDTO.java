package com.example.sales_control.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CustomerCreateDTO(

        @NotBlank(message = "Obrigatório informar o nome do cliente")
        String customerName,


        @Email(message = "Email inválido")
        String email,
        String phoneNumber

) {
}

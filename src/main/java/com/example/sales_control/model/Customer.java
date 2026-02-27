package com.example.sales_control.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name="customers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="customer_id")
    private UUID customerId;

    @Column(name="customer_name")
    private String costumerName;

    private String email;

    @Column(name = "phonenumber")
    private String phoneNumber;

}

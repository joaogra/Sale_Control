package com.example.sales_control.Services;

import com.example.sales_control.dto.customerDTOs.CustomerCreateDTO;
import com.example.sales_control.dto.customerDTOs.CustomerResponseDTO;
import com.example.sales_control.dto.customerDTOs.CustomerUpdateDTO;
import com.example.sales_control.model.Customer;
import com.example.sales_control.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {this.customerRepository = customerRepository;}

    public void createCustomer(CustomerCreateDTO dto) {

        Customer customer =  new Customer();
        customer.setEmail(dto.email());

        if(dto.email()!=null)customer.setCostumerName(dto.customerName());
        if(dto.customerName()!=null)customer.setPhoneNumber(dto.phoneNumber());

        customerRepository.save(customer);

    }

    public CustomerResponseDTO getCustomer(UUID customerId) {

        Customer customer = customerRepository.findById(customerId).orElseThrow(()-> new IllegalArgumentException("Customer not found"));

        return new CustomerResponseDTO(
                customer.getCustomerId(),
                customer.getCostumerName(),
                customer.getEmail(),
                customer.getPhoneNumber()
        );

    }

    public void updateCustomer(UUID customerId, CustomerUpdateDTO dto) {

        Customer customer = customerRepository.findById(customerId).orElseThrow(()-> new IllegalArgumentException("Customer not found"));

        if(dto.email()!=null)customer.setEmail(dto.email());
        if(dto.name()!=null)customer.setCostumerName(dto.name());
        if(dto.phoneNumber()!=null)customer.setPhoneNumber(dto.phoneNumber());

        customerRepository.save(customer);

    }

    public void deleteCustomer(UUID customerId) {

        Customer customer = customerRepository.findById(customerId).orElseThrow(()-> new IllegalArgumentException("Customer not found"));

        customerRepository.delete(customer);

    }
}

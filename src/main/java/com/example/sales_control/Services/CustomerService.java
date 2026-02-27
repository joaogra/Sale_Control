package com.example.sales_control.Services;

import com.example.sales_control.dto.CustomerCreateDTO;
import com.example.sales_control.model.Customer;
import com.example.sales_control.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

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
}

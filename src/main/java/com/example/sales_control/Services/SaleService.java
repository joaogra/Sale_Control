package com.example.sales_control.Services;

import com.example.sales_control.dto.saleDTO.SaleItemsRequestDTO;
import com.example.sales_control.dto.saleDTO.SaleRequestDTO;
import com.example.sales_control.enums.SaleStatus;
import com.example.sales_control.model.Customer;
import com.example.sales_control.model.Product;
import com.example.sales_control.model.ProductSale;
import com.example.sales_control.model.Sale;
import com.example.sales_control.repositories.CustomerRepository;
import com.example.sales_control.repositories.ProductRepository;
import com.example.sales_control.repositories.SaleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SaleService {

    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    public SaleService(SaleRepository saleRepository,  ProductRepository productRepository, CustomerRepository customerRepository) {
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional
    public void createSale(SaleRequestDTO dto){
        Sale sale = new Sale();

        Customer customer = customerRepository.findById(dto.customerId()).orElseThrow(()->new RuntimeException("Customer not found"));

        sale.setCustomer(customer);

        sale.setStatus(SaleStatus.Pendente);
        sale.setCreatedAt(new Date());

        Double total = 0.0;

        for(SaleItemsRequestDTO itemDTO : dto.items()){
            Product product = productRepository.findById(itemDTO.productId()).orElseThrow(()->new RuntimeException("Product not found"));

            ProductSale productSale = new ProductSale();
            productSale.setProduct(product);
            productSale.setQuantity(itemDTO.quantity());
            productSale.setUnPrice(product.getPrice());

            sale.addItem(productSale);

            total += productSale.getQuantity() * productSale.getProduct().getPrice();



        }

        sale.setTotalAmount(total);
        sale.setPaidAmount(0.00);

        saleRepository.save(sale);

    }

}

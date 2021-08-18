package com.sumanth.healthinsurance.service;

import com.sumanth.healthinsurance.model.Customer;
import com.sumanth.healthinsurance.model.ProductQuote;
import com.sumanth.healthinsurance.repository.CustomerRepository;
import com.sumanth.healthinsurance.repository.QuoteRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerService {
    final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> listCustomers(){
        return (List<Customer>) customerRepository.findAll();
    }

    @Transactional
    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }
}

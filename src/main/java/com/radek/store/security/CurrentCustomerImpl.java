package com.radek.store.security;

import com.radek.store.entity.users.Customer;
import com.radek.store.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CurrentCustomerImpl implements CurrentCustomer{

    private CustomerRepository customerRepository;

    @Autowired
    public CurrentCustomerImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public Customer getCustomer() {
        return customerRepository.findByUsername(SecurityUtils.getUsername()).orElseThrow(() -> new RuntimeException("Nie ma"));
    }
}

package com.radek.store.service;

import com.radek.store.entity.users.Customer;
import com.radek.store.exception.CustomerNotFoundException;
import com.radek.store.repository.CustomerRepository;
import com.radek.store.specification.CustomerSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public List<Customer> findAll(CustomerSpecification customerSpecification, Pageable pageable) {
        return customerRepository.findAll(customerSpecification, pageable).getContent();
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("nie ma"));
    }


    public Customer findByPhoneNumber(String phoneNumber) {
        return customerRepository.findCustomerByPhoneNumber(phoneNumber).orElseThrow(() -> new RuntimeException("nie ma"));
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }


    public Customer findByUsername(String username) {
        return customerRepository.findByUsername(username).orElseThrow(CustomerNotFoundException::new);
    }

    public long deleteByUsername(String username) {
        return customerRepository.deleteByUsername(username);
    }
}

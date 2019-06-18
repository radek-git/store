package com.radek.store.service;

import com.radek.store.entity.users.Customer;
import com.radek.store.repository.CategoryRepository;
import com.radek.store.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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


    public List<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable).getContent();
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
        return customerRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("Nie ma"));
    }

    public ResponseEntity<Object> deleteByUsername(String username) {
        return ResponseEntity.ok().body(customerRepository.deleteByUsername(username));
    }
}

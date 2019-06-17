package com.radek.store.controllers;

import com.radek.store.dto.OrderDTO;
import com.radek.store.dto.users.CustomerDTO;
import com.radek.store.entity.users.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {


    @GetMapping("/customer")
    public CustomerDTO getCurrentCustomer() {

    }


    @PatchMapping("/customer")
    public CustomerDTO updateCurrentCustomer(@RequestBody Customer customer) {

    }


    @DeleteMapping("/customer")
    public ResponseEntity<Object> deleteCurrentCustomer() {

    }


    @GetMapping("/customers")
    public List<CustomerDTO> getAll() {

    }






    @GetMapping("/customers/{username}")
    public CustomerDTO getByUsername(@PathVariable String username) {

    }

    @PostMapping("/customers")
    public CustomerDTO postCustomer(@RequestBody Customer customer) {

    }

    @PatchMapping("/customers/{username}")
    public CustomerDTO updateCustomer(@PathVariable String username, @RequestBody Customer customer) {

    }


    @DeleteMapping("/customers/{username}")
    public ResponseEntity<Object> deleteByUsername(@PathVariable String username) {

    }
}

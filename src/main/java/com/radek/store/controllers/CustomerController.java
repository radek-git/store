package com.radek.store.controllers;

import com.radek.store.dto.OrderDTO;
import com.radek.store.dto.ProductDTO;
import com.radek.store.dto.users.CustomerDTO;
import com.radek.store.entity.users.Customer;
import com.radek.store.mapper.CustomerMapper;
import com.radek.store.security.CurrentCustomer;
import com.radek.store.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {


    private CustomerService customerService;
    private CustomerMapper customerMapper;
    private CurrentCustomer currentCustomer;

    @Autowired
    public CustomerController(CustomerService customerService, CustomerMapper customerMapper, CurrentCustomer currentCustomer) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
        this.currentCustomer = currentCustomer;
    }

    @GetMapping("/customer")
    public CustomerDTO getCurrentCustomer() {
        return customerMapper.toDTO(currentCustomer.getCustomer());
    }


//    @PatchMapping("/customer")
//    public CustomerDTO updateCurrentCustomer(@RequestBody Customer customer) {
//
//    }


//    @DeleteMapping("/customer")
//    public ResponseEntity<Object> deleteCurrentCustomer() {
//
//    }


    @GetMapping("/customers")
    public List<CustomerDTO> getAll() {
        return customerMapper.toDTO(customerService.findAll());
    }


//    @GetMapping("/customer/orders")
//    public List<OrderDTO> getCurrentCustomerOrders() {
//        return orderMapper.toDTO(orderService.findAllByUsername(currentCustomer.getCustomer().getUsername()));
//    }

//    @GetMapping("/customers/{username}/orders")
//    public List<OrderDTO> getOrdersByUsername(@PathVariable String username) {
//        return orderMapper.toDTO(orderService.findAllByUsername(username));
//    }

//    @GetMapping("/customer/orders/{id}/products")
//    public List<ProductDTO> getProductsByOrderIdForCurrentCustomer(@PathVariable Long id) {
//
//    }




    @GetMapping("/customers/{username}")
    public CustomerDTO getByUsername(@PathVariable String username) {
        return customerMapper.toDTO(customerService.findByUsername(username));
    }

    @PostMapping("/customers")
    public CustomerDTO postCustomer(@RequestBody Customer customer) {
        return customerMapper.toDTO(customerService.save(customer));
    }

//    @PatchMapping("/customers/{username}")
//    public CustomerDTO updateCustomer(@PathVariable String username, @RequestBody Customer customer) {
//
//    }


//    @DeleteMapping("/customers/{username}")
//    public ResponseEntity<Object> deleteByUsername(@PathVariable String username) {
//
//    }
}

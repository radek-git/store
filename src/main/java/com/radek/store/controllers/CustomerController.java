package com.radek.store.controllers;

import com.radek.store.annotation.PageableDefaults;
import com.radek.store.dto.OrderDTO;
import com.radek.store.dto.ProductDTO;
import com.radek.store.dto.users.CustomerDTO;
import com.radek.store.entity.users.Customer;
import com.radek.store.mapper.CustomerMapper;
import com.radek.store.mapper.OrderMapper;
import com.radek.store.mapper.ProductMapper;
import com.radek.store.repository.ProductRepository;
import com.radek.store.security.CurrentCustomer;
import com.radek.store.service.CustomerService;
import com.radek.store.service.OrderService;
import com.radek.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {


    private CustomerService customerService;
    private CustomerMapper customerMapper;
    private CurrentCustomer currentCustomer;
    private ProductService productService;
    private ProductMapper productMapper;
    private OrderService orderService;
    private OrderMapper orderMapper;

    @Autowired
    public CustomerController(CustomerService customerService, CustomerMapper customerMapper,
                              CurrentCustomer currentCustomer, ProductService productService,
                              ProductMapper productMapper, OrderService orderService, OrderMapper orderMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
        this.currentCustomer = currentCustomer;
        this.productService = productService;
        this.productMapper = productMapper;
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }


    @GetMapping("/customer")
    public CustomerDTO getCurrentCustomer() {
        return customerMapper.toDTO(currentCustomer.getCustomer());
    }

    @GetMapping("/customers/{username}/orders")
    public List<OrderDTO> getOrdersByUsername(@PathVariable String username) {
        return orderMapper.toDTO(orderService.findAllByUsername(username));
    }


    @GetMapping("/customers")
    public List<CustomerDTO> getAll(@PageableDefaults(size = 20, minSize = 20, maxSize = 50) Pageable pageable) {
        return customerMapper.toDTO(customerService.findAll(pageable));
    }


    @GetMapping("/customer/orders")
    public List<OrderDTO> getCurrentCustomerOrders() {
        return orderMapper.toDTO(orderService.findAllByUsername(currentCustomer.getCustomer().getUsername()));
    }



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




    @DeleteMapping("/customer")
    public ResponseEntity<Object> deleteCurrentCustomer() {
        return ResponseEntity.ok().body(customerService.deleteByUsername(currentCustomer.getCustomer().getUsername()));
    }


    @DeleteMapping("/customers/{username}")
    public ResponseEntity<Object> deleteByUsername(@PathVariable String username) {
        return ResponseEntity.ok().body(customerService.deleteByUsername(username));
    }









    }







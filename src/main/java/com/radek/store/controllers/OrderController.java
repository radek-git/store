package com.radek.store.controllers;

import com.radek.store.dto.OrderDTO;
import com.radek.store.dto.ProductDTO;
import com.radek.store.mapper.OrderMapper;
import com.radek.store.mapper.ProductMapper;
import com.radek.store.security.CurrentCustomer;
import com.radek.store.security.CurrentEmployee;
import com.radek.store.service.OrderService;
import com.radek.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    private OrderService orderService;
    private OrderMapper orderMapper;
    private CurrentCustomer currentCustomer;
    private CurrentEmployee currentEmployee;
    private ProductService productService;
    private ProductMapper productMapper;

    @Autowired
    public OrderController(OrderService orderService, OrderMapper orderMapper,
                           CurrentCustomer currentCustomer, CurrentEmployee currentEmployee,
                           ProductService productService, ProductMapper productMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
        this.currentCustomer = currentCustomer;
        this.currentEmployee = currentEmployee;
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping("/orders")
    public List<OrderDTO> getAll () {
        return orderMapper.toDTO(orderService.findAll());
    }


    @GetMapping("/orders/{id}")
    public OrderDTO getById(@PathVariable Long id) {
        return orderMapper.toDTO(orderService.findById(id));
    }

//
//    @GetMapping("/orders/{id}/products")
//    public List<ProductDTO> getProductsByOrderId(@PathVariable Long id) {
//
//    }
















}

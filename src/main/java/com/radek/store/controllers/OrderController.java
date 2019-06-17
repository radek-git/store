package com.radek.store.controllers;

import com.radek.store.dto.OrderDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {



    @GetMapping("/orders")
    public List<OrderDTO> getAll () {

    }


    @GetMapping("/orders/{id}")
    public OrderDTO getById(@PathVariable Long id) {

    }


    @GetMapping("/customers/{username}/orders")
    public List<OrderDTO> getOrdersByUsername(@PathVariable String username) {

    }


    @GetMapping("/customers/{username}/orders/{orderId}")
    public OrderDTO getCustomerOrderById (@PathVariable String username, @PathVariable Long orderId) {

    }

    @GetMapping("/customer/orders")
    public List<OrderDTO> getCurrentCustomerOrders() {

    }


    @GetMapping("/customer/orders/{orderId}")
    public OrderDTO getCurrentCustomerOrdersById (@PathVariable Long orderId) {

    }


    @GetMapping("/employee/orders")
    public List<OrderDTO> getCurrentEmployeeOrders() {

    }

    @GetMapping("/employees/{username}/orders)")
    public List<OrderDTO> getEmployeeOrders(@PathVariable String username) {

    }


}

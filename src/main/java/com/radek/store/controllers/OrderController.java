package com.radek.store.controllers;

import com.radek.store.dto.OrderDTO;
import com.radek.store.mapper.OrderMapper;
import com.radek.store.security.CurrentCustomer;
import com.radek.store.security.CurrentEmployee;
import com.radek.store.service.OrderService;
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

    @Autowired
    public OrderController(OrderService orderService, OrderMapper orderMapper,
                           CurrentCustomer currentCustomer, CurrentEmployee currentEmployee) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
        this.currentCustomer = currentCustomer;
        this.currentEmployee = currentEmployee;
    }

    @GetMapping("/orders")
    public List<OrderDTO> getAll () {
        return orderMapper.toDTO(orderService.findAll());
    }


    @GetMapping("/orders/{id}")
    public OrderDTO getById(@PathVariable Long id) {
        return orderMapper.toDTO(orderService.findById(id));
    }


    @GetMapping("/customers/{username}/orders")
    public List<OrderDTO> getOrdersByUsername(@PathVariable String username) {
        return orderMapper.toDTO(orderService.findAllByUsername(username));
    }


//    @GetMapping("/customers/{username}/orders/{orderId}")
//    public OrderDTO getCustomerOrderById (@PathVariable String username, @PathVariable Long orderId) {
//        return orderMapper.toDTO(orderService.findAllByCustomer_UsernameAndOrderById(username, orderId));
//    }

    @GetMapping("/customer/orders")
    public List<OrderDTO> getCurrentCustomerOrders() {
        return orderMapper.toDTO(orderService.findAllByUsername(currentCustomer.getCustomer().getUsername()));
    }


//    @GetMapping("/customer/orders/{orderId}")
//    public OrderDTO getCurrentCustomerOrdersById (@PathVariable Long orderId) {
//        return orderMapper.toDTO(orderService.findAllByCustomer_UsernameAndOrderById(
//                currentCustomer.getCustomer().getUsername(), orderId));
//    }


    @GetMapping("/employee/orders")
    public List<OrderDTO> getCurrentEmployeeOrders() {
        return orderMapper.toDTO(orderService.findAllByUsername(currentEmployee.getEmployee().getUsername()));
    }

    @GetMapping("/employees/{username}/orders)")
    public List<OrderDTO> getEmployeeOrders(@PathVariable String username) {
        return orderMapper.toDTO(orderService.findAllByUsername(username));
    }


}

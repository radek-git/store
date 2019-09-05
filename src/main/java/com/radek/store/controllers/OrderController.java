package com.radek.store.controllers;

import com.radek.store.annotation.IsCustomer;
import com.radek.store.annotation.IsEmployee;
import com.radek.store.annotation.PageableDefaults;
import com.radek.store.dto.OrderDTO;
import com.radek.store.dto.OrderProductDTO;
import com.radek.store.dto.PostOrderDTO;
import com.radek.store.entity.Order;
import com.radek.store.entity.users.User;
import com.radek.store.mapper.OrderMapper;
import com.radek.store.mapper.OrderProductMapper;
import com.radek.store.mapper.ProductMapper;
import com.radek.store.security.CurrentCustomer;
import com.radek.store.security.CurrentEmployee;
import com.radek.store.service.OrderService;
import com.radek.store.service.ProductService;
import com.radek.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class OrderController {

    private OrderService orderService;
    private OrderMapper orderMapper;
    private CurrentCustomer currentCustomer;
    private CurrentEmployee currentEmployee;
    private ProductService productService;
    private ProductMapper productMapper;
    private OrderProductMapper orderProductMapper;
    private UserService userService;

    @Autowired
    public OrderController(OrderService orderService, OrderMapper orderMapper,
                           CurrentCustomer currentCustomer, CurrentEmployee currentEmployee,
                           ProductService productService, ProductMapper productMapper,
                           OrderProductMapper orderProductMapper, UserService userService) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
        this.currentCustomer = currentCustomer;
        this.currentEmployee = currentEmployee;
        this.productService = productService;
        this.productMapper = productMapper;
        this.orderProductMapper = orderProductMapper;
        this.userService = userService;
    }

    @IsEmployee
    @GetMapping("/orders")
    public List<OrderDTO> getAll (@PageableDefaults(size = 20, minSize = 20, maxSize = 50) Pageable pageable) {
        return orderMapper.toDTO(orderService.findAll(pageable));
    }


    @IsEmployee
    @GetMapping("/orders/{id}")
    public OrderDTO getById(@PathVariable Long id) {
        return orderMapper.toDTO(orderService.findById(id));
    }

    @IsEmployee
    @GetMapping("/orders/{id}/products")
    public List<OrderProductDTO> getProductsByOrderId(@PathVariable Long id) {
        return orderProductMapper.toDTO(orderService.findById(id).getOrderProducts());
    }

    @PreAuthorize("isAuthenticated() and ((hasRole('ROLE_CUSTOMER') " +
            "and #order.customer.username == authentication.principal.username) " +
            "or ((hasRole('ROLE_EMPLOYEE') and #order.employee.username == authentication.principal.username)))")
    @PostMapping("/orders")
    public OrderDTO postOrder(@RequestBody PostOrderDTO postOrderDTO) {
        return orderMapper.toDTO(orderService.save(orderMapper.toEntity(postOrderDTO))); // todo cena calkowita
    }

    //klient może usunąć tylko swoje zamówienie
//    @IsCustomer
//    @PatchMapping("/orders/{id}")
//    public OrderDTO update(@PathVariable Long id, @RequestBody PatchOrderDTO patchOrderDTO) {
//        Optional<User> user = userService.getCurrentUser();
//        Order customerOrder = orderService.findById(id);
//
//    }

//    @IsEmployee
//    @DeleteMapping("/orders/{id}")
//    public ResponseEntity<Object> deleteById(@PathVariable Long id) {
//        return ResponseEntity.ok().body(orderService.deleteById(id));
//    }

















}

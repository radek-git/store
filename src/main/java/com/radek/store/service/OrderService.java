package com.radek.store.service;

import com.radek.store.entity.Order;
import com.radek.store.repository.OrderRepository;
import com.radek.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private ProductRepository productRepository;


    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("NIe ma"));
    }

    public List<Order> findByCustomerId(Long customer_id) {
        return orderRepository.findAllByCustomer_Id(customer_id);
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }


    public List<Order> findAllByUsername(String username) {
        return orderRepository.findAllByCustomer_Username(username);
    }

    public List<Order> findProductsByOrderId(Long id) {
        return productRepository.findProductByOrderId(id);
    }

//    public Order findAllByCustomer_UsernameAndOrderById(String username, Long id) {
//        return orderRepository.findAllByCustomer_UsernameAndOrderById(username, id).orElseThrow(() -> new RuntimeException("Nie ma"));
//    }


}

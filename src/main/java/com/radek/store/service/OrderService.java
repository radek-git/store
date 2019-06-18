package com.radek.store.service;

import com.radek.store.entity.Order;
import com.radek.store.repository.OrderRepository;
import com.radek.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;



    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public List<Order> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable).getContent();
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

    public ResponseEntity<Object> deleteById(Long id) {
        return ResponseEntity.ok().body(orderRepository.deleteOrderById(id));
    }


    public List<Order> findAllByUsername(String username) {
        return orderRepository.findAllByCustomer_Username(username);
    }

    public List<Order> findOrdersByStore_Id(Long id, Pageable pageable) {
        return orderRepository.findOrdersByStore_Id(id, pageable);
    }




//    public Order findAllByCustomer_UsernameAndOrderById(String username, Long id) {
//        return orderRepository.findAllByCustomer_UsernameAndOrderById(username, id).orElseThrow(() -> new RuntimeException("Nie ma"));
//    }


}

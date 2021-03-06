package com.radek.store.repository;

import com.radek.store.entity.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByCustomer_Id(Long customer_id);

    List<Order> findAllByCustomer_Username(String username);

    List<Order> findOrdersByStore_Id(Long id, Pageable pageable);

    long deleteOrderById(Long id);

    Optional<Order> findByEmployee_UsernameAndId(String username, Long id);

    Optional<Order> findByCustomerUsernameAndId(String username, Long id);

    Optional<Order> findByIdAndStore_Id(Long orderId, Long id);


//    Optional<Order> findAllByCustomer_UsernameAndOrderById(String username, Long id);


}

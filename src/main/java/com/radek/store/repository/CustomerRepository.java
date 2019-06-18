package com.radek.store.repository;

import com.radek.store.entity.users.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {
    Optional<Customer> findCustomerByPhoneNumber(String phoneNumber);

    Optional<Customer> findByUsername(String username);

    ResponseEntity<Object> deleteByUsername(String username);
}

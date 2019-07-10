package com.radek.store.repository;

import com.radek.store.entity.Order;
import com.radek.store.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {



    List<Product> findAllByPriceIsGreaterThan(BigDecimal price);

    List<Product> findAllByBrand_Id(Long id, Pageable pageable);

    List<Product> findAllByCategory_Id(Long id, Pageable pageable);

    long deleteProductById(Long id);




}

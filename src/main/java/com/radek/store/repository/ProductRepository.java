package com.radek.store.repository;

import com.radek.store.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByBrand(String brand);

    List<Product> findAllByBrandAndName(String brand, String name);

    List<Product> findAllByCategoryAndBrandAndPriceGreaterThanAndPriceLessThan (String category, String brand, BigDecimal minPrice, BigDecimal maxPrice);

    List<Product> findAllByPriceIsGreaterThan(BigDecimal price);

    void deleteByName(String name);
}

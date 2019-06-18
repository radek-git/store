package com.radek.store.service;

import com.radek.store.entity.Product;
import com.radek.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("NIe ma"));
    }

    public List<Product> findByBrand(String brand) {
        return productRepository.findAllByBrand(brand);
    }


    public List<Product> findByBrandAndName(String brand, String name) {
        return productRepository.findAllByBrandAndName(brand, name);
    }


    public List<Product> findByPriceGreaterThan(BigDecimal price) {
        return productRepository.findAllByPriceIsGreaterThan(price);
    }

    public List<Product> findByCategoryAndBrandAndPriceGreaterThanAndLessThan
            (String category, String brand, BigDecimal minPrice, BigDecimal maxPrice) {
        return productRepository.findAllByCategoryAndBrandAndPriceGreaterThanAndPriceLessThan(category,
                brand, minPrice, maxPrice);
    }


    public Product save(Product product) {
        return productRepository.save(product);
    }


    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }


    public void deleteByName(String name) {
        productRepository.deleteByName(name);
    }


//    public List<Product> findAllByOrderIdAndUsername(String username, Long id) {
//
//
//    }
}

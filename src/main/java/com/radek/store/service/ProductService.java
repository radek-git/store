package com.radek.store.service;

import com.radek.store.entity.Product;
import com.radek.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
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


    public List<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable).getContent();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("NIe ma"));
    }


    public Product save(Product product) {
        return productRepository.save(product);
    }


    public ResponseEntity<Object> deleteById(Long id) {
        return ResponseEntity.ok().body(productRepository.deleteProductById(id));
    }


    public List<Product> findByBrandId(Long id, Pageable pageable) {
        return productRepository.findAllByBrand_Id(id, pageable);
    }

    public List<Product> findAllByCategory_Id(Long id, Pageable pageable) {
        return productRepository.findAllByCategory_Id(id, pageable);
    }

}

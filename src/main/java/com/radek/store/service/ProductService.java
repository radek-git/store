package com.radek.store.service;

import com.radek.store.entity.Product;
import com.radek.store.exception.BrandNotFoundException;
import com.radek.store.repository.BrandRepository;
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
    private BrandRepository brandRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, BrandRepository brandRepository) {
        this.productRepository = productRepository;
        this.brandRepository = brandRepository;
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
        brandRepository.findById(id).orElseThrow(BrandNotFoundException::new);
        return productRepository.findAllByBrand_Id(id, pageable);
    }

    public List<Product> findAllByCategory_Id(Long id, Pageable pageable) {
        return productRepository.findAllByCategory_Id(id, pageable);
    }

}

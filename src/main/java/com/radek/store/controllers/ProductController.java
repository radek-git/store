package com.radek.store.controllers;

import com.radek.store.annotation.PageableDefaults;
import com.radek.store.dto.ProductDTO;
import com.radek.store.entity.Product;
import com.radek.store.mapper.ProductMapper;
import com.radek.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private ProductService productService;
    private ProductMapper productMapper;


    @Autowired
    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }


    @GetMapping("/products")
    public List<ProductDTO> getAll(@PageableDefaults(size = 20, minSize = 20, maxSize = 50) Pageable pageable) {
        return productMapper.toDTO(productService.findAll(pageable));
    }


    @GetMapping("/products/{id}")
    public ProductDTO getById(@PathVariable Long id) {
        return productMapper.toDTO(productService.findById(id));
    }


    @PostMapping("/products")
    public ProductDTO postProduct(@RequestBody Product product) {
        return productMapper.toDTO(productService.save(product));
    }

//    @PatchMapping("/products/{id}")
//    public ProductDTO update(@PathVariable Long id,  @RequestBody Product product) {
//
//    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok().body(productService.deleteById(id));
    }
}

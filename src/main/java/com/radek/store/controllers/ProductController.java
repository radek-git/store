package com.radek.store.controllers;

import com.radek.store.dto.ProductDTO;
import com.radek.store.entity.Product;
import com.radek.store.mapper.ProductMapper;
import com.radek.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<ProductDTO> getAll() {
        return productMapper.toDTO(productService.findAll());
    }





//    @GetMapping("/products/{id}")



    @PostMapping("/products")
    public ProductDTO postProduct(@RequestBody Product product) {
        return productMapper.toDTO(productService.save(product));
    }

//    @PatchMapping("/products/{name}")
//    public ProductDTO update(@PathVariable String name,  @RequestBody Product product) {
//
//    }

//    @DeleteMapping("/products/{name}")
//    public ResponseEntity<Object> deleteByName(@PathVariable String name) {
//
//    }
}

package com.radek.store.controllers;

import com.radek.store.dto.ProductDTO;
import com.radek.store.mapper.ProductMapper;
import com.radek.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/products/{brand}")
    public List<ProductDTO> getByName(@PathVariable String brand) {
        return productMapper.toDTO(productService.findByBrand(brand));
    }

    @GetMapping("/products/{brand}/{name}")
    public List<ProductDTO> getProductByBrandAndName(@PathVariable String brand, @PathVariable String name) {
        return productMapper.toDTO(productService.findByBrandAndName(brand, name));
    }
}

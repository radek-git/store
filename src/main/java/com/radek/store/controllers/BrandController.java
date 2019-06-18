package com.radek.store.controllers;

import com.radek.store.annotation.PageableDefaults;
import com.radek.store.dto.BrandDTO;
import com.radek.store.dto.ProductDTO;
import com.radek.store.entity.Brand;
import com.radek.store.entity.Product;
import com.radek.store.mapper.BrandMapper;
import com.radek.store.mapper.ProductMapper;
import com.radek.store.service.BrandService;
import com.radek.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BrandController {

    private BrandService brandService;
    private BrandMapper brandMapper;
    private ProductService productService;
    private ProductMapper productMapper;

    @Autowired
    public BrandController(BrandService brandService, BrandMapper brandMapper, ProductService productService, ProductMapper productMapper) {
        this.brandService = brandService;
        this.brandMapper = brandMapper;
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping("/brands")
    public List<BrandDTO> getAll(@PageableDefaults(size = 20, minSize = 20, maxSize = 50) Pageable pageable) {
        return brandMapper.toDTO(brandService.findAll(pageable));
    }

    @GetMapping("/brands/{id}")
    public BrandDTO getById(@PathVariable Long id) {
        return brandMapper.toDTO(brandService.findById(id));
    }

    @GetMapping("/brands/{id}/products")
    public List<ProductDTO> getProductsByBrandId(@PathVariable Long id, @PageableDefaults(size = 20, minSize = 20, maxSize = 50) Pageable pageable) {
        return productMapper.toDTO(productService.findByBrandId(id, pageable));
    }



    @PostMapping("/brands")
    public BrandDTO postBrand(@RequestBody Brand brand) {
        return brandMapper.toDTO(brandService.save(brand));
    }


//    @PatchMapping("/brands/{id}")
//    public BrandDTO updateBrand(@PathVariable Long id, @RequestBody Brand brand) {
//
//    }


    @DeleteMapping("/brands/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok().body((brandService.deleteById(id)));
    }


}

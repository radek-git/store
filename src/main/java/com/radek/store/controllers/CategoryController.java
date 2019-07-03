package com.radek.store.controllers;

import com.radek.store.annotation.IsEmployee;
import com.radek.store.annotation.PageableDefaults;
import com.radek.store.dto.CategoryDTO;
import com.radek.store.dto.ProductDTO;
import com.radek.store.entity.Category;
import com.radek.store.mapper.CategoryMapper;
import com.radek.store.mapper.ProductMapper;
import com.radek.store.service.CategoryService;
import com.radek.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private CategoryService categoryService;
    private CategoryMapper categoryMapper;
    private ProductService productService;
    private ProductMapper productMapper;


    @Autowired
    public CategoryController(CategoryService categoryService, CategoryMapper categoryMapper, ProductService productService, ProductMapper productMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping("/categories")
    public List<CategoryDTO> getAll(@PageableDefaults(size = 20, minSize = 20, maxSize = 50) Pageable pageable) {
        return categoryMapper.toDTO(categoryService.findAll(pageable));
    }

    @GetMapping("/categories/{id}")
    public CategoryDTO getById(@PathVariable Long id) {
        return categoryMapper.toDTO(categoryService.findById(id));
    }


    @GetMapping("/category/{id}/products")
    public List<ProductDTO> getProductsByCategoryId(@PathVariable Long id, @PageableDefaults(size = 20, minSize = 20, maxSize = 50) Pageable pageable) {
        return productMapper.toDTO(productService.findAllByCategory_Id(id, pageable));
    }

    @IsEmployee
    @PostMapping("/categories")
    public CategoryDTO postCategory(@RequestBody Category category) {
        return categoryMapper.toDTO(categoryService.save(category));
    }

//    @IsEmployee
//    @PatchMapping("/categories/{id}")
//    public CategoryDTO update(@RequestBody Category category) {
//
//    }


    @IsEmployee
    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok().body(categoryService.deleteById(id));
    }


}

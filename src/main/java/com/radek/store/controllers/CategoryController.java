package com.radek.store.controllers;

import com.radek.store.dto.CategoryDTO;
import com.radek.store.entity.Category;
import com.radek.store.mapper.CategoryMapper;
import com.radek.store.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private CategoryService categoryService;
    private CategoryMapper categoryMapper;

    @Autowired
    public CategoryController(CategoryService categoryService, CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }


    @GetMapping("/categories")
    public List<CategoryDTO> getAll() {
        return categoryMapper.toDTO(categoryService.findAll());
    }

//    @GetMapping("/categories/{id}")


    //    @GetMapping("/category/{id}/products")

    @PostMapping("/categories")
    public CategoryDTO postCategory(@RequestBody Category category) {
        return categoryMapper.toDTO(categoryService.save(category));
    }

//    @PatchMapping("/categories/{id}")


//    @DeleteMapping("/categories/{id}")

}

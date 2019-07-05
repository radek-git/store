package com.radek.store.controllers;

import com.radek.store.annotation.IsEmployee;
import com.radek.store.annotation.PageableDefaults;
import com.radek.store.dto.categories.CategoryDTO;
import com.radek.store.dto.products.ProductDTO;
import com.radek.store.entity.Category;
import com.radek.store.entity.users.User;
import com.radek.store.mapper.CategoryMapper;
import com.radek.store.mapper.ProductMapper;
import com.radek.store.service.CategoryService;
import com.radek.store.service.ProductService;
import com.radek.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private CategoryService categoryService;
    private CategoryMapper categoryMapper;
    private ProductService productService;
    private ProductMapper productMapper;
    private UserService userService;


    @Autowired
    public CategoryController(CategoryService categoryService, CategoryMapper categoryMapper,
                              ProductService productService, ProductMapper productMapper,
                              UserService userService) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
        this.productService = productService;
        this.productMapper = productMapper;
        this.userService = userService;
    }

//    @GetMapping("/categories")
//    public List<CategoryDTO> getAll(@PageableDefaults(size = 20, minSize = 20, maxSize = 50) Pageable pageable) {
//        return categoryMapper.toDTO(categoryService.findAll(pageable));
//    }


    @GetMapping("/categories")
    public ResponseEntity<Object> getAll(@PageableDefaults(size = 20, minSize = 20, maxSize = 50) Pageable pageable) {
        Optional<User> user = userService.getCurrentUser();

        if (user.isPresent() && user.get().getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_ADMIN"))) {
            return ResponseEntity.ok().body(categoryMapper.toAdminCategoryDTO(categoryService.findAll(pageable)));
        } else if (user.isPresent() && user.get().getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_EMPLOYEE"))) {
            return ResponseEntity.ok().body(categoryMapper.toEmployeeCategoryDTO(categoryService.findAll(pageable)));
        } else {
            return ResponseEntity.ok().body(categoryMapper.toDTO(categoryService.findAll(pageable)));
        }
    }



//    @GetMapping("/categories/{id}")
//    public CategoryDTO getById(@PathVariable Long id) {
//        return categoryMapper.toDTO(categoryService.findById(id));
//    }


    @GetMapping("/categories/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        Optional<User> user = userService.getCurrentUser();

        if (user.isPresent() && user.get().getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_ADMIN"))) {
            return ResponseEntity.ok().body(categoryMapper.toAdminCategoryDTO(categoryService.findById(id)));
        } else if (user.isPresent() && user.get().getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_EMPLOYEE"))) {
            return ResponseEntity.ok().body(categoryMapper.toEmployeeCategoryDTO(categoryService.findById(id)));
        } else {
            return ResponseEntity.ok().body(categoryMapper.toDTO(categoryService.findById(id)));
        }
    }




    //nie działa - 404
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

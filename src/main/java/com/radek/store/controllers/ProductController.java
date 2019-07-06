package com.radek.store.controllers;

import com.radek.store.annotation.IsEmployee;
import com.radek.store.annotation.PageableDefaults;
import com.radek.store.dto.products.ProductDTO;
import com.radek.store.entity.Product;
import com.radek.store.entity.users.User;
import com.radek.store.mapper.EmployeeMapper;
import com.radek.store.mapper.ProductMapper;
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
public class ProductController {

    private ProductService productService;
    private ProductMapper productMapper;
    private UserService userService;



    @Autowired
    public ProductController(ProductService productService, ProductMapper productMapper,
                             UserService userService) {
        this.productService = productService;
        this.productMapper = productMapper;
        this.userService = userService;

    }




    @GetMapping("/products")
    public ResponseEntity<Object> getAll(@PageableDefaults(size = 20, maxSize = 20, minSize = 2) Pageable pageable) {
        Optional<User> user = userService.getCurrentUser();

        if (user.isPresent() && user.get().getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_ADMIN"))) {
            return ResponseEntity.ok().body(productMapper.toAdminProductDTO(productService.findAll(pageable)));
        } else if (user.isPresent() && user.get().getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_EMPLOYEE"))) {
            return ResponseEntity.ok().body(productMapper.toEmployeeProductDTO(productService.findAll(pageable)));
        } else {
            return ResponseEntity.ok().body(productMapper.toDTO(productService.findAll(pageable)));
        }

    }



    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        Optional<User> user = userService.getCurrentUser();

        if (user.isPresent() && user.get().getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_ADMIN"))) {
            return ResponseEntity.ok().body(productMapper.toAdminProductDTO(productService.findById(id)));
        } else if (user.isPresent() && user.get().getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_EMPLOYEE"))) {
            return ResponseEntity.ok().body(productMapper.toEmployeeProductDTO(productService.findById(id)));
        } else {
            return ResponseEntity.ok().body(productMapper.toDTO(productService.findById(id)));
        }
    }

    @IsEmployee
    @PostMapping("/products")
    public ProductDTO postProduct(@RequestBody Product product) {
        return productMapper.toDTO(productService.save(product));
    }

//    @IsEmployee
//    @PatchMapping("/products/{id}")
//    public ProductDTO update(@PathVariable Long id,  @RequestBody Product product) {
//
//    }

    @IsEmployee
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok().body(productService.deleteById(id));
    }
}

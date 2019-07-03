package com.radek.store.controllers;

import com.radek.store.annotation.IsEmployee;
import com.radek.store.annotation.PageableDefaults;
import com.radek.store.dto.ProductDTO;
import com.radek.store.entity.Product;
import com.radek.store.mapper.EmployeeMapper;
import com.radek.store.mapper.ProductMapper;
import com.radek.store.service.ProductService;
import com.radek.store.service.UserService;
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
    private UserService userService;



    @Autowired
    public ProductController(ProductService productService, ProductMapper productMapper,
                             EmployeeMapper employeeMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
        this.userService = userService;

    }


    @GetMapping("/products")
    public List<ProductDTO> getAll(@PageableDefaults(size = 20, minSize = 20, maxSize = 50) Pageable pageable) {
        return productMapper.toDTO(productService.findAll(pageable));
    }


    @GetMapping("/products/{id}")
    public ProductDTO getById(@PathVariable Long id) {
//        Optional<User> optionalUser = userService.getCurrentUser();
//
//        if (optionalUser.isPresent() && optionalUser.get().getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_EMPLOYEE"))) {
//            return ResponseEntity.ok().body(productMapper.toEmployeeProductDTO(productService.findById(id)));
//        } else {
//            return ResponseEntity.ok().body(productMapper.toDTO(productService.findById(id)));
//        }

        return productMapper.toDTO(productService.findById(id));
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

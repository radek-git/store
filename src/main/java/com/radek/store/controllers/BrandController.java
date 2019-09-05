package com.radek.store.controllers;

import com.radek.store.annotation.IsEmployee;
import com.radek.store.annotation.PageableDefaults;
import com.radek.store.dto.brands.BrandDTO;
import com.radek.store.dto.brands.PatchBrandDTO;
import com.radek.store.dto.products.ProductDTO;
import com.radek.store.entity.Brand;
import com.radek.store.entity.users.User;
import com.radek.store.mapper.BrandMapper;
import com.radek.store.mapper.ProductMapper;
import com.radek.store.service.BrandService;
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
public class BrandController {

    private BrandService brandService;
    private BrandMapper brandMapper;
    private ProductService productService;
    private ProductMapper productMapper;
    private UserService userService;

    @Autowired
    public BrandController(BrandService brandService, BrandMapper brandMapper, ProductService productService,
                           ProductMapper productMapper, UserService userService) {
        this.brandService = brandService;
        this.brandMapper = brandMapper;
        this.productService = productService;
        this.productMapper = productMapper;
        this.userService = userService;
    }


    @GetMapping("/brands")
    public ResponseEntity<Object> getAll(@PageableDefaults(size = 50, minSize = 50, maxSize = 50) Pageable pageable) {
        Optional<User> user = userService.getCurrentUser();

        if (user.isPresent() && user.get().getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_ADMIN"))) {
            return ResponseEntity.ok().body(brandMapper.toAdminBrandDTO(brandService.findAll(pageable)));
        } else if (user.isPresent() && user.get().getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_EMPLOYEE"))) {
            return ResponseEntity.ok().body(brandMapper.toEmployeeBrandDTO(brandService.findAll(pageable)));
        } else {
            return ResponseEntity.ok().body(brandMapper.toDTO(brandService.findAll(pageable)));
        }
    }


    @GetMapping("/brands/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        Optional<User> user = userService.getCurrentUser();

        if (user.isPresent() && user.get().getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_ADMIN"))) {
            return ResponseEntity.ok().body(brandMapper.toAdminBrandDTO(brandService.findById(id)));
        } else if (user.isPresent() && user.get().getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_EMPLOYEE"))) {
            return ResponseEntity.ok().body(brandMapper.toEmployeeBrandDTO(brandService.findById(id)));
        } else {
            return ResponseEntity.ok().body(brandMapper.toDTO(brandService.findById(id)));
        }
    }




    @GetMapping("/brands/{id}/products")
    public List<ProductDTO> getProductsByBrandId(@PathVariable Long id, @PageableDefaults(size = 20, minSize = 20, maxSize = 50) Pageable pageable) {
        return productMapper.toDTO(productService.findByBrandId(id, pageable));
    }


    @IsEmployee
    @PostMapping("/brands")
    public BrandDTO postBrand(@RequestBody BrandDTO brandDTO) {
        return brandMapper.toDTO(brandService.save(brandMapper.toEntity(brandDTO)));
    }


    @IsEmployee
    @PatchMapping("/brands/{id}")
    public BrandDTO updateBrand(@PathVariable Long id, @RequestBody PatchBrandDTO patchBrandDTO) {
        Brand brand = brandService.findById(id);

        if (patchBrandDTO.getName() != null) {
                brand.setName(patchBrandDTO.getName());
        }

        return brandMapper.toDTO(brandService.save(brand));
    }

    @IsEmployee
    @DeleteMapping("/brands/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) {
        Brand brand = brandService.findById(id);
        brandService.deleteById(id);

        return ResponseEntity.ok().body(null);
    }



}

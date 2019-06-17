package com.radek.store.controllers;

import com.radek.store.dto.BrandDTO;
import com.radek.store.entity.Brand;
import com.radek.store.mapper.BrandMapper;
import com.radek.store.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BrandController {

    private BrandService brandService;
    private BrandMapper brandMapper;

    @Autowired
    public BrandController(BrandService brandService, BrandMapper brandMapper) {
        this.brandService = brandService;
        this.brandMapper = brandMapper;
    }


    @GetMapping("/brands")
    public List<BrandDTO> getAll() {
        return brandMapper.toDTO(brandService.findAll());
    }

    @GetMapping("/brands/{name}")
    public BrandDTO getByName(@PathVariable String name) {
        return brandMapper.toDTO(brandService.findByName(name));
    }

    @PostMapping("/brands")
    public BrandDTO postBrand(@RequestBody Brand brand) {
        return brandMapper.toDTO(brandService.save(brand));
    }

//    @PatchMapping("/brands/{name}")
//    public BrandDTO updateBrand(@PathVariable String name, @RequestBody Brand brand) {
//
//    }

//    @DeleteMapping("/brands/{name}")
//    public ResponseEntity<Object> deleteByName(@PathVariable String name) {
//        return brandMapper.toDTO(brandService.deleteByName(name));
//    }
}

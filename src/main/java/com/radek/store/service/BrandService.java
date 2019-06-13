package com.radek.store.service;

import com.radek.store.entity.Brand;
import com.radek.store.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {


    private BrandRepository brandRepository;

    @Autowired
    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    public Brand findByName(String name) {
        return brandRepository.findByName(name).orElseThrow(() -> new RuntimeException("nie ma"));
    }

    public Brand save(Brand brand) {
        return brandRepository.save(brand);
    }

    public Brand update(Brand brand) {
        return brandRepository.save(brand);
    }

    public void deleteByName(String name) {
        brandRepository.deleteByName(name);
    }
}

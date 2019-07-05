package com.radek.store.service;

import com.radek.store.entity.Brand;
import com.radek.store.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BrandService {


    private BrandRepository brandRepository;

    @Autowired
    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> findAll(Pageable pageable) {
        return brandRepository.findAll(pageable).getContent();
    }


    public Brand save(Brand brand) {
        return brandRepository.save(brand);
    }

    public Brand update(Brand brand) {
        return brandRepository.save(brand);
    }



    public Brand findById(Long id) {
        return brandRepository.findById(id).orElseThrow(() -> new RuntimeException("Nie ma"));
    }

    @Transactional
    public void deleteById(Long id) {
        brandRepository.deleteById(id);
    }

}

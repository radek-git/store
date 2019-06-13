package com.radek.store.service;

import com.radek.store.entity.Category;
import com.radek.store.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }



    public List<Category> findAll() {
        return categoryRepository.findAll();
    }


    public Category findByName(String name) {
        return categoryRepository.findByName(name).orElseThrow(() -> new RuntimeException("nie ma"));
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("nie ma"));
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteByName(String name) {
        categoryRepository.deleteByName(name);
    }
}

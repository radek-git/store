package com.radek.store.service;

import com.radek.store.entity.Category;
import com.radek.store.exception.CategoryNotFoundException;
import com.radek.store.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }



    public List<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable).getContent();
    }


    public Category findByName(String name) {
        return categoryRepository.findByName(name).orElseThrow(CategoryNotFoundException::new);
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

    public ResponseEntity<Object> deleteById(Long id) {
        return ResponseEntity.ok().body(categoryRepository.deleteCategoryById(id));
    }

}

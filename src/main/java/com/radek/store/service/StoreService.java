package com.radek.store.service;

import com.radek.store.entity.Store;
import com.radek.store.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    private StoreRepository storeRepository;


    @Autowired
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }


    public List<Store> findAll() {
        return storeRepository.findAll();
    }

    public Store findById(Long id) {
        return storeRepository.findById(id).orElseThrow(() -> new RuntimeException("NIe ma"));
    }

    public Store findByName(String name) {
        return storeRepository.findByName(name).orElseThrow(() -> new RuntimeException("NIe ma"));
    }

    public Store save(Store store) {
        return storeRepository.save(store);
    }

    public void deleteById(Long id) {
        storeRepository.deleteById(id);
    }

    public void deleteByName(String name) {
        storeRepository.deleteByName(name);
    }
}

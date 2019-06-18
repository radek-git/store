package com.radek.store.service;

import com.radek.store.entity.Store;
import com.radek.store.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    private StoreRepository storeRepository;


    @Autowired
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }


    public List<Store> findAll(Pageable pageable) {
        return storeRepository.findAll(pageable).getContent();
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

    public ResponseEntity<Object> deleteById(Long id) {
        return ResponseEntity.ok().body(storeRepository.deleteStoreById(id));
    }

}

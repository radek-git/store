package com.radek.store.repository;

import com.radek.store.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

    Optional<Brand> findByName(String name);

    ResponseEntity<Object> deleteBrandById(Long id);


}

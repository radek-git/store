package com.radek.store.repository;

import com.radek.store.SampleDataGenerator;
import com.radek.store.entity.*;
import com.radek.store.entity.users.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ProductRepository productRepository;


    @Test
    public void shouldFindById() {
        Category category = SampleDataGenerator.getCategory();
        Brand brand = SampleDataGenerator.getBrand();
        Store store = SampleDataGenerator.getEmptyStore();
        Position position = SampleDataGenerator.getEmployeePosition();
        Employee addedBy = SampleDataGenerator.getEmployee1(store, position);
//        Employee updatedBy = SampleDataGenerator.getEmployee2(store, position);

        Product product = new Product("dildo", new BigDecimal("100"), category, brand, addedBy, addedBy);

        testEntityManager.persistAndFlush(product);

        Optional<Product> optionalProduct = productRepository.findById(product.getId());

        assertTrue(optionalProduct.isPresent());
    }


    @Test
    public void shouldFindByName() {
        Category category = SampleDataGenerator.getCategory();
        Brand brand = SampleDataGenerator.getBrand();
        Store store = SampleDataGenerator.getEmptyStore();
        Position position = SampleDataGenerator.getEmployeePosition();
        Employee addedBy = SampleDataGenerator.getEmployee1(store, position);

        Product product = new Product("dildo", new BigDecimal("10"), category, brand, addedBy, addedBy);

        testEntityManager.persistAndFlush(product);

        Optional<Product> optionalProduct = productRepository.findByName(product.getName());
        assertThat(product, samePropertyValuesAs(optionalProduct.get()));
    }


    @Test
    public void shouldDeleteById() {
        Category category = SampleDataGenerator.getCategory();
        Brand brand = SampleDataGenerator.getBrand();
        Store store = SampleDataGenerator.getEmptyStore();
        Position position = SampleDataGenerator.getEmployeePosition();
        Employee addedBy = SampleDataGenerator.getEmployee1(store, position);

        Product product = new Product("dildo", new BigDecimal("10"), category, brand, addedBy, addedBy);

        testEntityManager.persistAndFlush(product);
        testEntityManager.remove(product);

        Optional<Product> optionalProduct = productRepository.findById(product.getId());

        assertFalse(optionalProduct.isPresent());
    }
}

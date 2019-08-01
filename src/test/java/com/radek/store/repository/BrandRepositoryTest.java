package com.radek.store.repository;

import com.radek.store.entity.Brand;
import org.flywaydb.core.Flyway;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BrandRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private BrandRepository brandRepository;

//    @Autowired
//    private Flyway flyway;
//
//    @Before
//    public void before() {
//        flyway.clean();
//        flyway.migrate();
//    }

    @Test
    public void shouldFindAllBrands() {
//        brandRepository.deleteAll();

        Brand brand1 = new Brand("Wedel");
        Brand brand2 = new Brand("AAAA");

        testEntityManager.persistAndFlush(brand1);
        testEntityManager.persistAndFlush(brand2);

        List<Brand> brands = brandRepository.findAll();

        assertThat(brands, hasSize(12));
    }

    @Test
    public void shouldFindById() {
        Brand brand = new Brand("Wedel");

        testEntityManager.persistAndFlush(brand);

        Optional<Brand> optionalBrand = brandRepository.findById(brand.getId());

        assertTrue(optionalBrand.isPresent());
        assertThat(brand, samePropertyValuesAs(optionalBrand.get()));

    }

    @Test
    public void shouldFindByName() {
        Brand brand = new Brand("Wedel");

        testEntityManager.persistAndFlush(brand);

        Optional<Brand> optionalBrand = brandRepository.findByName(brand.getName());

        assertThat(brand, samePropertyValuesAs(optionalBrand.get()));
    }

    @Test
    public void shouldNotSaveTwoBrandsWithSameNames() {
        Brand brand1 = new Brand("Wedel");
        Brand brand2 = new Brand("Wedel");

        testEntityManager.persistAndFlush(brand1);

        assertThrows(PersistenceException.class, () -> {
            testEntityManager.persistAndFlush(brand2);
        });
    }

    @Test
    public void shouldDeleteById() {
        Brand brand1 = new Brand("Wedel");

        testEntityManager.persistAndFlush(brand1);

        testEntityManager.remove(brand1);

        Optional<Brand> optionalBrand = brandRepository.findById(brand1.getId());

        assertThat(optionalBrand.isPresent(), is(false));

    }

}

package com.radek.store.repository;

import com.radek.store.SampleDataGenerator;
import com.radek.store.entity.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.PersistenceException;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private CategoryRepository categoryRepository;


    @Test
    public void shouldFindById() {
        Category category = SampleDataGenerator.getCategory();

        testEntityManager.persistAndFlush(category);

        Optional<Category> optionalCategory = categoryRepository.findById(category.getId());

        assertThat(category, samePropertyValuesAs(optionalCategory.get()));
    }

    @Test
    public void shouldFindByName() {
        Category category = SampleDataGenerator.getCategory();

        testEntityManager.persistAndFlush(category);

        Optional<Category> optionalCategory = categoryRepository.findByName(category.getName());

        assertThat(category, samePropertyValuesAs(optionalCategory.get()));
    }


    @Test
    public void shouldNotSaveTwoSameCategories() {
        Category category1 = SampleDataGenerator.getCategory();
        Category category2 = SampleDataGenerator.getCategory();

        testEntityManager.persistAndFlush(category1);

        assertThrows(PersistenceException.class, () -> {
            testEntityManager.persistAndFlush(category2);
        });
    }

    @Test
    public void shouldDeleteById() {
        Category category = SampleDataGenerator.getCategory();

        testEntityManager.persistAndFlush(category);
        testEntityManager.remove(category);

        Optional<Category> optionalCategory = categoryRepository.findById(category.getId());

        assertFalse(optionalCategory.isPresent());
    }
}

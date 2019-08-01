package com.radek.store.repository;

import com.radek.store.SampleDataGenerator;
import com.radek.store.entity.Store;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StoreRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private StoreRepository storeRepository;


    @Test
    public void shouldFindById() {
        Store store = SampleDataGenerator.getEmptyStore();

        testEntityManager.persistAndFlush(store);
        Optional<Store> optionalStore = storeRepository.findById(store.getId());

        assertThat(store, samePropertyValuesAs(optionalStore.get()));
    }

    @Test
    public void shouldNotSaveTwoStoresWithSameNames() {
        Store store1 = SampleDataGenerator.getEmptyStore();
        Store store2 = SampleDataGenerator.getEmptyStore();

        testEntityManager.persistAndFlush(store1);

        assertThrows(PersistenceException.class, ()->{
            testEntityManager.persistAndFlush(store2);
        });
    }


    @Test
    public void shouldNotSaveWithNameNull() {
        Store store = SampleDataGenerator.getEmptyStore();
        store.setName(null);

        assertThrows(ConstraintViolationException.class, ()->{
            testEntityManager.persistAndFlush(store);
        });
    }

    @Test
    public void shouldNotSaveWithPhoneNull() {
        Store store = SampleDataGenerator.getEmptyStore();
        store.setPhoneNumber(null);
        assertThrows(ConstraintViolationException.class, ()->{
            testEntityManager.persistAndFlush(store);
        });
    }

    @Test
    public void shouldNotSaveWithNameNullAndPhoneNull() {
        Store store = SampleDataGenerator.getEmptyStore();
        store.setName(null);
        store.setPhoneNumber(null);
        assertThrows(ConstraintViolationException.class, ()->{
            testEntityManager.persistAndFlush(store);
        });
    }


    @Test
    public void shouldDeleteById() {
        Store store = SampleDataGenerator.getEmptyStore();
        testEntityManager.persistAndFlush(store);
        testEntityManager.remove(store);
        Optional<Store> optionalStore = storeRepository.findById(store.getId());

        assertFalse(optionalStore.isPresent());
    }
}

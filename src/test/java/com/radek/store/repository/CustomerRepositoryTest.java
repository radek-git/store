package com.radek.store.repository;

import com.radek.store.SampleDataGenerator;
import com.radek.store.entity.users.Customer;
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
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private CustomerRepository customerRepository;


    @Test
    public void shouldFindById() {
        Customer customer = SampleDataGenerator.getCustomer();

        testEntityManager.persistAndFlush(customer);
        Optional<Customer> optionalCustomer = customerRepository.findById(customer.getId());
        assertThat(customer, samePropertyValuesAs(optionalCustomer.get()));
    }

    @Test
    public void shouldNotSaveTwoSameCustomers() {
        Customer customer1 = SampleDataGenerator.getCustomer();
        Customer customer2 = SampleDataGenerator.getCustomer();

        testEntityManager.persistAndFlush(customer1);

        assertThrows(PersistenceException.class, () -> {
            testEntityManager.persistAndFlush(customer2);
        });
    }

    @Test
    public void shouldNotSaveWithNameNull() {
        Customer customer = SampleDataGenerator.getCustomer();
        assertThrows(NullPointerException.class, () -> {
            customer.setName(null);
            testEntityManager.persistAndFlush(customer);
        });
    }
}

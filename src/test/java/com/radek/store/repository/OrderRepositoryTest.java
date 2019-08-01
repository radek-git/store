package com.radek.store.repository;

import com.radek.store.SampleDataGenerator;
import com.radek.store.entity.Order;
import com.radek.store.entity.Position;
import com.radek.store.entity.Store;
import com.radek.store.entity.users.Customer;
import com.radek.store.entity.users.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.PersistenceException;
import java.math.BigDecimal;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private OrderRepository orderRepository;



    @Test
    public void shouldNotSaveOrderWithNullStore() {
        Customer customer = SampleDataGenerator.getCustomer();
        Position position = SampleDataGenerator.getEmployeePosition();
        Store store = SampleDataGenerator.getEmptyStore();
        Employee employee = SampleDataGenerator.getEmployee1(store, position);
        Order order = new Order(customer, employee, null, new BigDecimal("10.50"), null);

        assertThrows(PersistenceException.class, ()->{
            testEntityManager.persistAndFlush(order);
        });
    }

    @Test
    public void shouldNotSaveOrderWithTotalPriceNull() {
        Customer customer = SampleDataGenerator.getCustomer();
        Position position = SampleDataGenerator.getEmployeePosition();
        Store store = SampleDataGenerator.getEmptyStore();
        Employee employee = SampleDataGenerator.getEmployee1(store, position);
        Order order = new Order(customer, employee, store, null, null);

        assertThrows(PersistenceException.class, ()->{
            testEntityManager.persistAndFlush(order);
        });
    }

    @Test
    public void shouldNotSaveOrderWithStoreNullAndTotalPriceNull() {
        Customer customer = SampleDataGenerator.getCustomer();
        Position position = SampleDataGenerator.getEmployeePosition();
        Store store = SampleDataGenerator.getEmptyStore();
        Employee employee = SampleDataGenerator.getEmployee1(store, position);

        Order order = new Order(customer, employee, null, null, null);

        assertThrows(PersistenceException.class, ()->{
            testEntityManager.persistAndFlush(order);
        });
    }

    //todo napisać testy tam gdzie coś nie może być nullem


    @Test
    public void shouldFindById() {
        Customer customer = SampleDataGenerator.getCustomer();
        Position position = SampleDataGenerator.getEmployeePosition();
        Store store = SampleDataGenerator.getEmptyStore();
        Employee employee = SampleDataGenerator.getEmployee1(store, position);
        Order order = new Order(customer, employee, store, new BigDecimal("100"), null);

        testEntityManager.persistAndFlush(order);

        Optional<Order> optionalOrder = orderRepository.findById(order.getId());

        assertThat(order, samePropertyValuesAs(optionalOrder.get()));
    }
}

package com.radek.store.repository;

import com.radek.store.entity.Role;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.PersistenceException;
import java.util.Optional;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RoleRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private RoleRepository roleRepository;


    @Test
    public void shouldFindById() {
        Role role = new Role("admin");

        testEntityManager.persistAndFlush(role);

        Optional<Role> optionalRole = roleRepository.findById(role.getId());

        MatcherAssert.assertThat(role, samePropertyValuesAs(optionalRole.get()));
    }

    @Test
    public void shouldNotSaveTwoSameRoles() {
        Role role1 = new Role("admin");
        Role role2 = new Role("admin");

        testEntityManager.persistAndFlush(role1);

        assertThrows(PersistenceException.class, () -> {
            testEntityManager.persistAndFlush(role2);
        });

    }

    @Test
    public void shouldDeleteById() {
        Role role1 = new Role("admin");

        testEntityManager.persistAndFlush(role1);
        testEntityManager.remove(role1);

        Optional<Role> optionalRole = roleRepository.findById(role1.getId());

        assertFalse(optionalRole.isPresent());

    }

    @Test
    public void shouldNotSaveRoleNull() {
        Role role = new Role(null);

        assertThrows(PersistenceException.class, ()->{
            testEntityManager.persistAndFlush(role);
        });
    }
}

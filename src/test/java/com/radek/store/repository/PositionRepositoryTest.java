package com.radek.store.repository;

import com.radek.store.SampleDataGenerator;
import com.radek.store.entity.Position;
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
public class PositionRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private PositionRepository positionRepository;


    @Test
    public void shouldFindById() {
        Position position = SampleDataGenerator.getEmployeePosition();

        testEntityManager.persistAndFlush(position);

        Optional<Position> optionalPosition = positionRepository.findById(position.getId());

        assertThat(position, samePropertyValuesAs(optionalPosition.get()));
    }

    @Test
    public void shouldNotSaveTwoSamePositions() {
        Position position1 = SampleDataGenerator.getEmployeePosition();
        Position position2 = SampleDataGenerator.getEmployeePosition();

        testEntityManager.persistAndFlush(position1);

        assertThrows(PersistenceException.class, () -> {
            testEntityManager.persistAndFlush(position2);
        });
    }

    @Test
    public void shouldFindByName() {
        Position position = SampleDataGenerator.getEmployeePosition();

        testEntityManager.persistAndFlush(position);

        Optional<Position> optionalPosition = positionRepository.findByName(position.getName());

        assertThat(position, samePropertyValuesAs(optionalPosition.get()));

    }

    @Test
    public void shouldDeleteById() {
        Position position = SampleDataGenerator.getEmployeePosition();

        testEntityManager.persistAndFlush(position);
        testEntityManager.remove(position);

        Optional<Position> optionalPosition = positionRepository.findById(position.getId());

        assertFalse(optionalPosition.isPresent());
    }
}

package com.radek.store.service;

import com.radek.store.entity.Position;
import com.radek.store.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PositionService {

    private PositionRepository positionRepository;

    @Autowired
    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }


    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    public Position findByName(String name) {
        return positionRepository.findByName(name).orElseThrow(() -> new RuntimeException("NIe ma"));
    }


    public Position save(Position position) {
        return positionRepository.save(position);
    }

    public void deleteByName(String name) {
        positionRepository.deleteByName(name);
    }
}

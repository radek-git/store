package com.radek.store.controllers;

import com.radek.store.dto.PositionDTO;
import com.radek.store.entity.Position;
import com.radek.store.mapper.PositionMapper;
import com.radek.store.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PositionController {

    private PositionService positionService;
    private PositionMapper positionMapper;

    @Autowired
    public PositionController(PositionService positionService, PositionMapper positionMapper) {
        this.positionService = positionService;
        this.positionMapper = positionMapper;
    }


    @GetMapping("/positions")
    public List<PositionDTO> getAll() {
        return positionMapper.toDTO(positionService.findAll());
    }

    @GetMapping("/positions/{name}")
    public PositionDTO getByName(@PathVariable String name) {
        return positionMapper.toDTO(positionService.findByName(name));
    }

    @PostMapping("/positions")
    public PositionDTO postPosition(@RequestBody Position position) {
        return positionMapper.toDTO(positionService.save(position));
    }

//    @PatchMapping("/positions/{name}")
//    public PositionDTO update(@PathVariable String name, @RequestBody Position position) {
//
//    }

//    @DeleteMapping("/positions/{name}")
//    public ResponseEntity<Object> deleteByName(@PathVariable String name) {
//
//    }
}

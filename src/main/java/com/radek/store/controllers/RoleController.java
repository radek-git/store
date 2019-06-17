package com.radek.store.controllers;

import com.radek.store.dto.RoleDTO;
import com.radek.store.entity.Role;
import com.radek.store.mapper.RoleMapper;
import com.radek.store.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleController {

    private RoleService roleService;
    private RoleMapper roleMapper;

    @Autowired
    public RoleController(RoleService roleService, RoleMapper roleMapper) {
        this.roleService = roleService;
        this.roleMapper = roleMapper;
    }


    @GetMapping("/roles")
    public List<RoleDTO> getAll() {
        return roleMapper.toDTO(roleService.findAll());
    }

    @PostMapping("/roles")
    public RoleDTO postRole(@RequestBody Role role) {
        return roleMapper.toDTO(roleService.save(role));
    }

//    @PatchMapping("roles/{name}")
//    public RoleDTO update(@PathVariable String name, @RequestBody Role role) {
//
//    }

//    @DeleteMapping("/roles/{name}")
//    public ResponseEntity<Object> deleteByName(@PathVariable String name) {
//
//    }
}

package com.radek.store.controllers;

import com.radek.store.dto.users.EmployeeDTO;
import com.radek.store.entity.users.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {


    @GetMapping("/employee")
    public EmployeeDTO getCurrentEmployee() {

    }


    @PatchMapping("/employee")
    public EmployeeDTO updateCurrentEmployee(@RequestBody Employee employee) {

    }


    @DeleteMapping("/employee")
    public ResponseEntity<Object> deleteCurrentEmployee() {

    }


    @GetMapping("/employees")
    public List<EmployeeDTO> getAll() {

    }


    @GetMapping("/employees/{username}")
    public EmployeeDTO getByUsername(@PathVariable String username) {

    }

    @PostMapping("/employees")
    public EmployeeDTO postEmployee(@RequestBody Employee employee) {

    }

    @PatchMapping("/employees/{username}")
    public EmployeeDTO updateEmployee(@PathVariable String username, @RequestBody Employee employee) {

    }


    @DeleteMapping("/employees/{username}")
    public ResponseEntity<Object> deleteByUsername(@PathVariable String username) {

    }


}

package com.radek.store.service;

import com.radek.store.entity.users.Employee;
import com.radek.store.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }



    public List<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable).getContent();
    }

    public List<Employee> findAllByStore_Id(Long id, Pageable pageable) {
        return employeeRepository.findAllByStore_Id(id, pageable);
    }


    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("NIe ma"));
    }

    public Employee findByUsername (String username) {
        return employeeRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("NIe ma"));
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    public ResponseEntity<Object> deleteByUsername(String username) {
        return ResponseEntity.ok().body(employeeRepository.deleteByUsername(username));
    }
}

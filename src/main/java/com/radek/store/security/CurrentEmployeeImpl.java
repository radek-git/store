package com.radek.store.security;

import com.radek.store.entity.users.Employee;
import com.radek.store.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CurrentEmployeeImpl implements CurrentEmployee{

    private EmployeeRepository employeeRepository;

    @Autowired
    public CurrentEmployeeImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee getEmployee() {
        return employeeRepository.findByUsername(SecurityUtils.getUsername()).orElseThrow(() -> new RuntimeException("Nie ma"));
    }
}

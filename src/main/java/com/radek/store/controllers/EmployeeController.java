package com.radek.store.controllers;

import com.radek.store.dto.OrderDTO;
import com.radek.store.dto.users.EmployeeDTO;
import com.radek.store.entity.users.Employee;
import com.radek.store.mapper.EmployeeMapper;
import com.radek.store.security.CurrentEmployee;
import com.radek.store.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {


    private EmployeeService employeeService;
    private EmployeeMapper employeeMapper;
    private CurrentEmployee currentEmployee;


    @Autowired
    public EmployeeController(EmployeeService employeeService, EmployeeMapper employeeMapper, CurrentEmployee currentEmployee) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
        this.currentEmployee = currentEmployee;
    }

    @GetMapping("/employee")
    public EmployeeDTO getCurrentEmployee() {
        return employeeMapper.toDTO(currentEmployee.getEmployee());
    }


//    @PatchMapping("/employee")
//    public EmployeeDTO updateCurrentEmployee(@RequestBody Employee employee) {
//        return
//    }


//    @DeleteMapping("/employee")
//    public ResponseEntity<Object> deleteCurrentEmployee() {
//
//    }


    @GetMapping("/employees")
    public List<EmployeeDTO> getAll() {
        return employeeMapper.toDTO(employeeService.findAll());
    }


    @GetMapping("/employees/{username}")
    public EmployeeDTO getByUsername(@PathVariable String username) {
        return employeeMapper.toDTO(employeeService.findByUsername(username));
    }

//    @GetMapping("/employee/orders")
//    public List<OrderDTO> getCurrentEmployeeOrders() {
//        return orderMapper.toDTO(orderService.findAllByUsername(currentEmployee.getEmployee().getUsername()));
//    }
//
//    @GetMapping("/employees/{username}/orders)")
//    public List<OrderDTO> getEmployeeOrders(@PathVariable String username) {
//        return orderMapper.toDTO(orderService.findAllByUsername(username));
//    }



    @PostMapping("/employees")
    public EmployeeDTO postEmployee(@RequestBody Employee employee) {
        return employeeMapper.toDTO(employeeService.save(employee));
    }

//    @PatchMapping("/employees/{username}")
//    public EmployeeDTO updateEmployee(@PathVariable String username, @RequestBody Employee employee) {
//
//    }


//    @DeleteMapping("/employees/{username}")
//    public ResponseEntity<Object> deleteByUsername(@PathVariable String username) {
//
//    }


}

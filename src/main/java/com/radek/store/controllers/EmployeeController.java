package com.radek.store.controllers;

import com.radek.store.annotation.PageableDefaults;
import com.radek.store.dto.OrderDTO;
import com.radek.store.dto.users.EmployeeDTO;
import com.radek.store.entity.users.Employee;
import com.radek.store.mapper.EmployeeMapper;
import com.radek.store.mapper.OrderMapper;
import com.radek.store.security.CurrentEmployee;
import com.radek.store.service.EmployeeService;
import com.radek.store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {


    private EmployeeService employeeService;
    private EmployeeMapper employeeMapper;
    private CurrentEmployee currentEmployee;
    private OrderService orderService;
    private OrderMapper orderMapper;


    @Autowired
    public EmployeeController(EmployeeService employeeService, EmployeeMapper employeeMapper, CurrentEmployee currentEmployee, OrderService orderService, OrderMapper orderMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
        this.currentEmployee = currentEmployee;
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @GetMapping("/employee")
    public EmployeeDTO getCurrentEmployee() {
        return employeeMapper.toDTO(currentEmployee.getEmployee());
    }

    @GetMapping("/employees")
    public List<EmployeeDTO> getAll(@PageableDefaults(size = 20, minSize = 20, maxSize = 50) Pageable pageable) {
        return employeeMapper.toDTO(employeeService.findAll(pageable));
    }


    @GetMapping("/employees/{username}")
    public EmployeeDTO getByUsername(@PathVariable String username) {
        return employeeMapper.toDTO(employeeService.findByUsername(username));
    }

    @GetMapping("/employee/orders")
    public List<OrderDTO> getCurrentEmployeeOrders() {
        return orderMapper.toDTO(orderService.findAllByUsername(currentEmployee.getEmployee().getUsername()));
    }


    @GetMapping("/employees/{username}/orders)")
    public List<OrderDTO> getEmployeeOrders(@PathVariable String username) {
        return orderMapper.toDTO(orderService.findAllByUsername(username));
    }



    @PostMapping("/employees")
    public EmployeeDTO postEmployee(@RequestBody Employee employee) {
        return employeeMapper.toDTO(employeeService.save(employee));
    }





//    @PatchMapping("/employee")
//    public EmployeeDTO updateCurrentEmployee(@RequestBody Employee employee) {
//        return
//    }

    //    @PatchMapping("/employees/{username}")
//    public EmployeeDTO updateEmployee(@PathVariable String username, @RequestBody Employee employee) {
//
//    }


    @DeleteMapping("/employee")
    public ResponseEntity<Object> deleteCurrentEmployee() {
        return ResponseEntity.ok().body(employeeService.deleteByUsername(currentEmployee.getEmployee().getUsername()));
    }


    @DeleteMapping("/employees/{username}")
    public ResponseEntity<Object> deleteByUsername(@PathVariable String username) {
        return ResponseEntity.ok().body(employeeService.deleteByUsername(username));
    }










}

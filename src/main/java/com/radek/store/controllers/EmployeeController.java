package com.radek.store.controllers;

import com.radek.store.ApiResponse;
import com.radek.store.annotation.*;
import com.radek.store.dto.OrderDTO;
import com.radek.store.dto.employees.AuthEmployeeDTO;
import com.radek.store.dto.employees.EmployeeDTO;
import com.radek.store.entity.Order;
import com.radek.store.entity.users.Customer;
import com.radek.store.entity.users.Employee;
import com.radek.store.entity.users.User;
import com.radek.store.mapper.EmployeeMapper;
import com.radek.store.mapper.OrderMapper;
import com.radek.store.security.CurrentEmployee;
import com.radek.store.service.EmployeeService;
import com.radek.store.service.OrderService;
import com.radek.store.service.UserService;
import com.radek.store.specification.EmployeeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {


    private EmployeeService employeeService;
    private EmployeeMapper employeeMapper;
    private CurrentEmployee currentEmployee;
    private OrderService orderService;
    private OrderMapper orderMapper;
    private UserService userService;


    @Autowired
    public EmployeeController(EmployeeService employeeService, EmployeeMapper employeeMapper, CurrentEmployee currentEmployee, OrderService orderService, OrderMapper orderMapper, UserService userService) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
        this.currentEmployee = currentEmployee;
        this.orderService = orderService;
        this.orderMapper = orderMapper;
        this.userService = userService;
    }

    @IsEmployee
    @GetMapping("/employee")
    public AuthEmployeeDTO getCurrentEmployee() {
        return employeeMapper.toAuthEmployeeDTO(currentEmployee.getEmployee());
    }

    @IsAdminOrEmployee
    @GetMapping("/employees")
    public ResponseEntity<Object> getAll(EmployeeSpecification employeeSpecification,
                                         @PageableDefaults(size = 20, minSize = 20, maxSize = 50) Pageable pageable) {

        Optional<User> user = userService.getCurrentUser();
        if (user.isPresent() && user.get().getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_ADMIN"))) {
            return ResponseEntity.ok().body(employeeMapper.toAdminEmployeeDTOList(
                    employeeService.findAll(employeeSpecification, pageable)));

        } else if (user.isPresent() && user.get().getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_EMPLOYEE"))) {
            return ResponseEntity.ok().body(employeeMapper.toEmployeeEmployeeDTOList(
                    employeeService.findAll(employeeSpecification, pageable)));

        }

        return null;
    }



    @IsEmployee
    @GetMapping("/employee/orders")
    public List<OrderDTO> getCurrentEmployeeOrders() {
        return orderMapper.toDTO(((Employee) userService.getCurrentUser().get()).getOrders());
    }


    @IsEmployee
    @GetMapping("/employee/orders/{id}")
    public OrderDTO getCurrentEmployeeOrder(@PathVariable Long id) {
        return orderMapper.toDTO(orderService.findByEmployeeUsernameAndOrderId(userService.getCurrentUser().get().getUsername(), id));
    }


    @IsAdminOrEmployee
    @GetMapping("/employees/{username}")
    public ResponseEntity<Object> getByUsername(@PathVariable String username) {
    //dla pracownika powinno wyświetlać się mniej niż dla admina
        Optional<User> user = userService.getCurrentUser();

        if (user.isPresent() && user.get().getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_ADMIN"))) {
            return ResponseEntity.ok().body(employeeMapper.toAdminEmployeeDTO(employeeService.findByUsername(username)));
        } else if (user.isPresent() && user.get().getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_EMPLOYEE"))) {
            return ResponseEntity.ok().body(employeeMapper.toEmployeeEmployeeDTO(employeeService.findByUsername(username)));
        }
        return null;
    }

    @IsAdminOrEmployee
    @GetMapping("/employees/{username}/orders)")
    public List<OrderDTO> getEmployeeOrders(@PathVariable String username) {
        return orderMapper.toDTO(orderService.findAllByUsername(username));
    }


    @IsAdmin
    @PostMapping("/employees")
    public EmployeeDTO postEmployee(@RequestBody Employee employee) {
        return employeeMapper.toDTO(employeeService.save(employee));
    }




//    @IsEmployee  do zastanowienia czy on powinien być
//    @PatchMapping("/employee")
//    public EmployeeDTO updateCurrentEmployee(@RequestBody Employee employee) {
//        return
//    }



//    @IsAdmin
    //    @PatchMapping("/employees/{username}")
//    public EmployeeDTO updateEmployee(@PathVariable String username, @RequestBody Employee employee) {
//
//    }


//    @IsEmployee
//    @PatchMapping("/employee/orders/{id} ")
//    public OrderDTO updateOrderById(@PathVariable Long id) {
//
//    }



    @IsAdmin
    @DeleteMapping("/employees/{username}")
    public ResponseEntity<Object> deleteByUsername(@PathVariable String username) {
        return ResponseEntity.ok().body(employeeService.deleteByUsername(username));
    }










}

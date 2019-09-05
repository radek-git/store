package com.radek.store.controllers;

import com.radek.store.ApiResponse;
import com.radek.store.annotation.*;
import com.radek.store.dto.OrderDTO;
import com.radek.store.dto.customers.AuthenticatedCustomerDTO;
import com.radek.store.dto.customers.CustomerDTO;
import com.radek.store.dto.customers.PatchCustomerDTO;
import com.radek.store.entity.Order;
import com.radek.store.entity.users.Customer;
import com.radek.store.entity.users.Employee;
import com.radek.store.entity.users.User;
import com.radek.store.exception.OrderNotFoundException;
import com.radek.store.mapper.CustomerMapper;
import com.radek.store.mapper.OrderMapper;
import com.radek.store.mapper.OrderProductMapper;
import com.radek.store.mapper.ProductMapper;
import com.radek.store.service.*;
import com.radek.store.specification.CustomerSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private UserService userService;
    private CustomerService customerService;
    private CustomerMapper customerMapper;
    private ProductService productService;
    private ProductMapper productMapper;
    private OrderService orderService;
    private OrderMapper orderMapper;
    private OrderProductMapper orderProductMapper;



    @Autowired
    public CustomerController(UserService userService, CustomerService customerService,
                              CustomerMapper customerMapper, ProductService productService,
                              ProductMapper productMapper, OrderService orderService,
                              OrderMapper orderMapper, OrderProductMapper orderProductMapper
                              ) {
        this.userService = userService;
        this.customerService = customerService;
        this.customerMapper = customerMapper;
        this.productService = productService;
        this.productMapper = productMapper;
        this.orderService = orderService;
        this.orderMapper = orderMapper;
        this.orderProductMapper = orderProductMapper;

    }

    @IsCustomer
    @GetMapping("/customer")
    public AuthenticatedCustomerDTO getCurrentCustomer() {
        return customerMapper.toAuthDTO((Customer) userService.getCurrentUser().get());
    }

    @GetMapping("/customers")
    public ResponseEntity<Object> getAll(CustomerSpecification customerSpecification,
                                    @PageableDefaults(size = 20, minSize = 20, maxSize = 50) Pageable pageable) {

        Optional<User> user = userService.getCurrentUser();
        if (user.isPresent() && user.get().getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_ADMIN"))) {
            return ResponseEntity.ok().body(customerMapper.toAdminCustomerDTO(customerService.findAll(customerSpecification, pageable)));

        } else if (user.isPresent() && user.get().getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_EMPLOYEE"))) {
            return ResponseEntity.ok().body(customerMapper.toEmployeeCustomerDTO(customerService.findAll(customerSpecification, pageable)));

        } else {
            return ResponseEntity.ok().body(customerMapper.toDTO(customerService.findAll(customerSpecification, pageable)));
        }
    }

    @IsCustomer
    @GetMapping("/customer/orders")
    public List<OrderDTO> getCurrentCustomerOrders() {
        return orderMapper.toDTO(((Customer) userService.getCurrentUser().get()).getOrders());
    }

    @IsCustomer
    @GetMapping("/customer/orders/{id}")
    public OrderDTO getOrderById(@PathVariable Long id) {
        return orderMapper.toDTO(orderService.findByCustomerUsernameAndOrderId(userService.getCurrentUser().get().getUsername(), id));

    }

    @IsCustomer
    @GetMapping("/customer/orders/{id}/products")
    public ResponseEntity<Object> getProductsByOrderIdForCurrentCustomer(@PathVariable Long id) {
        Customer customer = (Customer) userService.getCurrentUser().get();

        Optional<Order> optionalOrder = customer.getOrders().stream().filter(order -> order.getId().equals(id)).findFirst();
        if (optionalOrder.isPresent()) {
            return ResponseEntity.ok().body(orderProductMapper.toDTO(optionalOrder.get().getOrderProducts()));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(HttpStatus.NOT_FOUND.value(), "not found"));
        }
    }



    @IsAdminOrCurrentUser
    @GetMapping("/customers/{username}/orders")
    public List<OrderDTO> getOrdersByUsername(@PathVariable String username) {
        return orderMapper.toDTO(orderService.findAllByUsername(username));
    }



    @IsAdminOrCurrentUser
    @GetMapping("/customers/{username}/orders/{id}")
    public OrderDTO findOrderById(@PathVariable Long id, @PathVariable String username) {
        Customer customer = customerService.findByUsername(username);
        Order order = customer.getOrders().stream().filter(o -> o.getId().equals(id)).findFirst().orElseThrow(OrderNotFoundException::new);
        return orderMapper.toDTO(order);
    }



    @GetMapping("/customers/{username}")
    public ResponseEntity<Object> getByUsername(@PathVariable String username) {

        Optional<User> user = userService.getCurrentUser();
        if (user.isPresent() && user.get().getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_ADMIN"))) {
            return ResponseEntity.ok().body(customerMapper.toAdminCustomerDTO(customerService.findByUsername(username)));

        } else if (user.isPresent() && user.get().getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_EMPLOYEE"))) {
            return ResponseEntity.ok().body(customerMapper.toEmployeeCustomerDTO(customerService.findByUsername(username)));

        } else {
            return ResponseEntity.ok().body(customerMapper.toDTO(customerService.findByUsername(username)));
        }
    }

    @PostMapping("/customers")
    public CustomerDTO postCustomer(@RequestBody Customer customer) {
        return customerMapper.toDTO(customerService.save(customer));

    }


    @IsEmployeeOrCurrentUser
    @PatchMapping("/customers/{username}")
    public CustomerDTO updateCustomer(@PathVariable String username, @RequestBody PatchCustomerDTO patchCustomerDTO) {
        Customer customer = customerService.findByUsername(username);

        Optional<User> user = userService.getCurrentUser();

        if (patchCustomerDTO.getName() != null) {
            customer.setName(patchCustomerDTO.getName());
        }
        if (patchCustomerDTO.getSurname() != null) {
            customer.setUsername(patchCustomerDTO.getSurname());
        }
        if (patchCustomerDTO.getUsername() != null) {
            customer.setUsername(patchCustomerDTO.getUsername());
        }
        if (patchCustomerDTO.getEmail() != null) {
            customer.setEmail(patchCustomerDTO.getEmail());
        }
        if (patchCustomerDTO.getPhoneNumber() != null) {
            customer.setPhoneNumber(patchCustomerDTO.getPhoneNumber());
        }
        if (patchCustomerDTO.getStreet() != null) {
            customer.setStreet(patchCustomerDTO.getStreet());
        }
        if (patchCustomerDTO.getCity() != null) {
            customer.setCity(patchCustomerDTO.getCity());
        }
        if (patchCustomerDTO.getPostalCode() != null) {
            customer.setPostalCode(patchCustomerDTO.getPostalCode());
        }


        if (user.isPresent() && user.get() instanceof Employee) {
           //metody dla admina/employee
            if (patchCustomerDTO.getExpired() != null) {
                customer.setExpired(patchCustomerDTO.getExpired());
            }
            if (patchCustomerDTO.getLocked() != null) {
                customer.setLocked(patchCustomerDTO.getLocked());
            }
            if (patchCustomerDTO.getCredentialsExpired() != null) {
                customer.setCredentialsExpired(patchCustomerDTO.getCredentialsExpired());
            }
            if (patchCustomerDTO.getEnabled() != null) {
                customer.setCredentialsExpired(patchCustomerDTO.getEnabled());
            }
        }

        return customerMapper.toDTO(customerService.save(customer));
    }



    @IsCustomer
    @DeleteMapping("/customer")
    public ResponseEntity<Object> deleteCurrentCustomer() {
        customerService.deleteByUsername(((Customer) userService.getCurrentUser().get()).getUsername());

        return ResponseEntity.ok().body(new ApiResponse(HttpStatus.OK.value(), "DELETED"));
    }


//    @IsCustomer
//    @DeleteMapping("/customer")
//    public ResponseEntity<Object> deleteCurrentCustomer() {
//        return ResponseEntity.ok().body(customerService.deleteByUsername());
//    }


    @IsEmployeeOrCurrentUser
    @DeleteMapping("/customers/{username}")
    public ResponseEntity<Object> deleteByUsername(@PathVariable String username) {
        return ResponseEntity.ok().body(customerService.deleteByUsername(username));
    }





    }







package com.radek.store.controllers;

import com.radek.store.annotation.IsAdmin;
import com.radek.store.annotation.IsEmployee;
import com.radek.store.annotation.PageableDefaults;
import com.radek.store.dto.OrderDTO;
import com.radek.store.dto.OrderProductDTO;
import com.radek.store.dto.StoreDTO;
import com.radek.store.dto.StoreProductDTO;
import com.radek.store.dto.employees.EmployeeDTO;
import com.radek.store.entity.Store;
import com.radek.store.mapper.*;
import com.radek.store.service.EmployeeService;
import com.radek.store.service.OrderService;
import com.radek.store.service.ProductService;
import com.radek.store.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StoreController {

    private StoreService storeService;
    private StoreMapper storeMapper;
    private EmployeeService employeeService;
    private EmployeeMapper employeeMapper;
    private OrderService orderService;
    private OrderMapper orderMapper;
    private ProductService productService;
    private ProductMapper productMapper;
    private StoreProductMapper storeProductMapper;
    private OrderProductMapper orderProductMapper;

    @Autowired
    public StoreController(StoreService storeService, StoreMapper storeMapper,
                           EmployeeService employeeService, EmployeeMapper employeeMapper,
                           OrderService orderService, OrderMapper orderMapper,
                           ProductService productService, ProductMapper productMapper,
                           StoreProductMapper storeProductMapper, OrderProductMapper orderProductMapper) {
        this.storeService = storeService;
        this.storeMapper = storeMapper;
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
        this.orderService = orderService;
        this.orderMapper = orderMapper;
        this.productService = productService;
        this.productMapper = productMapper;
        this.storeProductMapper = storeProductMapper;
        this.orderProductMapper = orderProductMapper;
    }


    @GetMapping("/stores")
    public List<StoreDTO> getAll(@PageableDefaults(size = 20, minSize = 20, maxSize = 50) Pageable pageable) {
        return storeMapper.toDTO(storeService.findAll(pageable));
    }

    @GetMapping("/stores/{id}")
    public StoreDTO getById(@PathVariable Long id) {
        return storeMapper.toDTO(storeService.findById(id));
    }

    @GetMapping("/stores/{id}/products")
    public List<StoreProductDTO> getStoreProductsById(@PathVariable Long id) {
        return storeProductMapper.toDTO(storeService.findById(id).getStoreProducts());
    }

    @IsEmployee
    @GetMapping("/stores/{id}/employees")
    public List<EmployeeDTO> getAllEmployeesByStore_Id(@PathVariable Long id, @PageableDefaults(size = 20, minSize = 20, maxSize = 50) Pageable pageable) {
        return employeeMapper.toDTO(employeeService.findAllByStore_Id(id, pageable));
    }

    @IsEmployee
    @GetMapping("/stores/{id}/orders")
    public List<OrderDTO> getOrdersByStore_Id(@PathVariable Long id, @PageableDefaults(size = 20, minSize = 20, maxSize = 50) Pageable pageable) {
        return orderMapper.toDTO(orderService.findOrdersByStore_Id(id, pageable));
    }

    @IsEmployee
    @GetMapping("/stores/{id}/orders/{orderId}")
    public OrderDTO getOrderByOrderIdAndStoreId(@PathVariable Long id, @PathVariable Long orderId) {
        return orderMapper.toDTO(orderService.findByOrderIdAndStoreId(orderId, id));
    }

    @IsEmployee
    @GetMapping("/stores/{id}/orders/{orderId}/products")
    public List<OrderProductDTO> getProductsByOrderIdAndStoreId(@PathVariable Long id, @PathVariable Long orderId) {
        return orderProductMapper.toDTO(orderService.findByOrderIdAndStoreId(orderId, id).getOrderProducts());
    }



    @IsAdmin
    @PostMapping("/stores")
    public StoreDTO postStore(@RequestBody Store store) {
        return storeMapper.toDTO(storeService.save(store));
    }


//    @IsAdmin
//    @PatchMapping("/stores/{id}")
//    public StoreDTO update(@RequestBody Store store) {
//
//    }



    @IsAdmin
    @DeleteMapping("/stores/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok().body(storeService.deleteById(id));
    }

}

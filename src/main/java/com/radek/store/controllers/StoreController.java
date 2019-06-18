package com.radek.store.controllers;

import com.radek.store.annotation.PageableDefaults;
import com.radek.store.dto.OrderDTO;
import com.radek.store.dto.ProductDTO;
import com.radek.store.dto.StoreDTO;
import com.radek.store.dto.users.EmployeeDTO;
import com.radek.store.entity.Store;
import com.radek.store.mapper.EmployeeMapper;
import com.radek.store.mapper.OrderMapper;
import com.radek.store.mapper.ProductMapper;
import com.radek.store.mapper.StoreMapper;
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

    @Autowired
    public StoreController(StoreService storeService, StoreMapper storeMapper,
                           EmployeeService employeeService, EmployeeMapper employeeMapper,
                           OrderService orderService, OrderMapper orderMapper,
                           ProductService productService, ProductMapper productMapper) {
        this.storeService = storeService;
        this.storeMapper = storeMapper;
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
        this.orderService = orderService;
        this.orderMapper = orderMapper;
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping("/stores")
    public List<StoreDTO> getAll(@PageableDefaults(size = 20, minSize = 20, maxSize = 50) Pageable pageable) {
        return storeMapper.toDTO(storeService.findAll(pageable));
    }

    @GetMapping("/stores/{id}")
    public StoreDTO getById(@PathVariable Long id) {
        return storeMapper.toDTO(storeService.findById(id));
    }

//    @GetMapping("/stores/{id}/products") - ze specification

    @GetMapping("/stores/{id}/employees")
    public List<EmployeeDTO> getAllEmployeesByStore_Id(@PathVariable Long id, @PageableDefaults(size = 20, minSize = 20, maxSize = 50) Pageable pageable) {
        return employeeMapper.toDTO(employeeService.findAllByStore_Id(id, pageable));
    }


    @GetMapping("/stores/{id}/orders")
    public List<OrderDTO> getOrdersByStore_Id(@PathVariable Long id, @PageableDefaults(size = 20, minSize = 20, maxSize = 50) Pageable pageable) {
        return orderMapper.toDTO(orderService.findOrdersByStore_Id(id, pageable));
    }

//    @GetMapping("/stores/{id}/orders/{orderId}/products")
//    public List<ProductDTO> getProductsByOrder_IdAndStore_Id(@PathVariable Long orderId, @PathVariable Long storeId) {
//        return productMapper.toDTO(orderService.findOrdersByStore_Id(storeId))
//    }


    @PostMapping("/stores")
    public StoreDTO postStore(@RequestBody Store store) {
        return storeMapper.toDTO(storeService.save(store));
    }


//    @PatchMapping("/stores/{id}")
//    public StoreDTO update(@RequestBody Store store) {
//
//    }



    @DeleteMapping("/stores/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok().body(storeService.deleteById(id));
    }

}

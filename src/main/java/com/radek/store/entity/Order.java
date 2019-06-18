package com.radek.store.entity;


import com.radek.store.entity.users.Customer;
import com.radek.store.entity.users.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Table(name = "orders")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order extends AbstractEntity{

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id")
    private Store store;

    private BigDecimal totalPrice;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderProduct> orderProducts = new ArrayList<>();
    //mappedBy można stosować tylko w połączeniu dwukierunkowym

}

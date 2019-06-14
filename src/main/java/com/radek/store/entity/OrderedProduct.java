package com.radek.store.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Table(name = "ordered_products")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderedProduct implements Serializable {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;


    private BigDecimal quantity;

    private BigDecimal price;

    private int position;



    public OrderedProduct(Product product, Order order) {
        this.product = product;
        this.order = order;
    }
}

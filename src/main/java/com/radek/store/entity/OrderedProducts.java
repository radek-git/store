package com.radek.store.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "ordered_products")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderedProducts {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;

    private BigDecimal quantity;

    private BigDecimal price;

    private int position;



    public OrderedProducts(Product product, Order order) {
        this.product = product;
        this.order = order;
    }
}

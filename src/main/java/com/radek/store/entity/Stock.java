package com.radek.store.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "stocks")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Stock extends AbstractEntity{

    @Id
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private BigDecimal quantity;


    public Stock(Store store, Product product) {
        this.store = store;
        this.product = product;
    }
}

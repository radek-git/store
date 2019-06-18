package com.radek.store.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Table(name = "store_products")
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class StoreProduct implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private BigDecimal quantity;


    public StoreProduct(Store store, Product product) {
        this.store = store;
        this.product = product;
    }
}

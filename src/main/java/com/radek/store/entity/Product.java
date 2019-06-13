package com.radek.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Table(name = "products")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product extends AbstractEntity{

    @NotEmpty
    private String name;

    @NotEmpty
    private BigDecimal price;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Category category;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Brand brand;


}

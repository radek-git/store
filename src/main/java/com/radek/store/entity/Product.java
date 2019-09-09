package com.radek.store.entity;

import com.radek.store.entity.users.Employee;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Table(name = "products")
@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product extends AbstractEntity{

    @NotEmpty
    private String name;

    @NotNull
    private BigDecimal price;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id")
    private Brand brand;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "added_by_employee_id")
    private Employee addedBy;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "updated_by_employee_id")
    private Employee updatedByEmp;


}

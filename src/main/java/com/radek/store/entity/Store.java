package com.radek.store.entity;

import com.radek.store.entity.users.Employee;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "stores")
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Store extends AbstractEntity{

    @NotEmpty
    private String name;

    @NotEmpty
    private String phoneNumber;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<StoreProduct> storeProducts = new HashSet<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Employee> employees = new HashSet<>();

}

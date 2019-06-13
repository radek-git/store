package com.radek.store.entity.users;


import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "customers")
@Entity(name = "Customer")
@NoArgsConstructor
public class Customer extends User{

    private String street;
    private String city;
    private String postCode;
}

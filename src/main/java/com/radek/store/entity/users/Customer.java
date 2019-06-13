package com.radek.store.entity.users;


import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@DiscriminatorValue("3")
public class Customer extends User{

    private String street;
    private String city;
    private String postCode;
}

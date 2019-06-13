package com.radek.store.entity.users;

import com.radek.store.entity.Store;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@DiscriminatorValue("2")
public class Employee extends User{


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private Store store;
}

package com.radek.store.entity.users;

import com.radek.store.entity.Position;
import com.radek.store.entity.Store;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "employees")
@Entity(name = "Employee")
@NoArgsConstructor
public class Employee extends User{


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private Store store;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;
}

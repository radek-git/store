package com.radek.store.entity.users;


import com.radek.store.entity.Order;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Table(name = "customers")
@Entity(name = "Customer")
@NoArgsConstructor
@Data
@AllArgsConstructor

public class Customer extends User{


    @Builder //pozwala utworzyć obiekt z polami z klasy nadrzędnej i customer
    public Customer(@NonNull String name, @NonNull String surname, @NonNull String username,
                    @NonNull @Email String email, @NonNull String password, @NonNull String phoneNumber,
                    String street, String city, String postalCode, Employee addedBy) {
        super(name, surname, username, email, password, phoneNumber);
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.addedBy = addedBy;
    }

    private String street;
    private String city;
    private String postalCode;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "added_by_employee_id")
    private Employee addedBy;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();
}

package com.radek.store.entity.users;


import com.radek.store.entity.AbstractEntity;
import com.radek.store.entity.Role;
import com.radek.store.entity.Store;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User extends AbstractEntity {


    private String name;
    private String surname;

    @Column(unique = true)
    private String username;

    @Email
    @Column(unique = true)
    private String email;
    private String password;
    private String phoneNumber;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private Store store;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<>();

    @Column(name = "is_expired")
    private boolean expired;

    @Column(name = "is_locked")
    private boolean locked;

    @Column(name = "is_credentials_expired")
    private boolean credentialsExpired;

    @Column(name = "is_enabled")
    private boolean enabled;

}

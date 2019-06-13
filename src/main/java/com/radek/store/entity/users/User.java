package com.radek.store.entity.users;


import com.radek.store.entity.AbstractEntity;
import com.radek.store.entity.Store;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Table(name = "users")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorColumn(name = "USER_TYPE_ID", discriminatorType = DiscriminatorType.INTEGER)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User extends AbstractEntity {


    private String name;
    private String surname;

    @Column(unique = true)
    private String username;

    @Email
    @Column(unique = true)
    private String email;
    private String password;
    private String phoneNumber;

    private Store store;

    @Column(name = "is_expired")
    private boolean expired;

    @Column(name = "is_locked")
    private boolean locked;

    @Column(name = "is_credentials_expired")
    private boolean credentialsExpired;

    @Column(name = "is_enabled")
    private boolean enabled;

}

package com.radek.store.entity.users;

import com.radek.store.entity.users.User;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@DiscriminatorValue("1")
public class Admin extends User {
}

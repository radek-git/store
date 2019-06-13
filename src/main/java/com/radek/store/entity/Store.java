package com.radek.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Table(name = "stores")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Store extends AbstractEntity{

    @NotEmpty
    private String name;

    @NotEmpty
    private String phoneNumber;
}

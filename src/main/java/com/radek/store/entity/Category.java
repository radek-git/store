package com.radek.store.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Table(name = "categories")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Category extends AbstractEntity{

    @NotEmpty
    @Column(unique = true)
    private String name;


}

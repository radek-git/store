package com.radek.store.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Table(name = "categories")
@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Category extends AbstractEntity{

    @NotEmpty
    @Column(unique = true)
    private String name;


}

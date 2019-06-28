package com.radek.store.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "roles")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Role extends AbstractEntity{

    private String name;
}

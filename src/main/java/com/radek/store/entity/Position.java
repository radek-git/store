package com.radek.store.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "positions")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Position extends AbstractEntity{

    private String name;
}

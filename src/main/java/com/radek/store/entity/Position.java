package com.radek.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "positions")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Position extends AbstractEntity{

    private String name;
}

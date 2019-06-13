package com.radek.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Table(name = "brands")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Brand extends AbstractEntity{

    @NotEmpty
    private String name;
}

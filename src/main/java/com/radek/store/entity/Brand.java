package com.radek.store.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Table(name = "brands")
@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Brand extends AbstractEntity{

    @NotEmpty
    private String name;
}

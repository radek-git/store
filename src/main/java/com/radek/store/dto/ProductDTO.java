package com.radek.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO extends AbstractDTO {

    private String name;
    private BigDecimal price;

    private Long categoryId;
    private Long brandId;
}

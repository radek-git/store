package com.radek.store.dto;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO extends AbstractDTO {

    private String name;
    private BigDecimal price;

    private Long categoryId;
    private Long brandId;
}

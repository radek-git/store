package com.radek.store.dto.products;

import com.radek.store.dto.AbstractDTO;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO  {

    private Long id;
    private String name;
    private BigDecimal price;

    private Long categoryId;
    private Long brandId;
}

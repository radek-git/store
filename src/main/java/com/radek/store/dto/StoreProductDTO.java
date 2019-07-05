package com.radek.store.dto;

import com.radek.store.dto.products.ProductDTO;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreProductDTO  {

    private Long storeId;
    private ProductDTO product;

    private BigDecimal quantity;
}

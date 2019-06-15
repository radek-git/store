package com.radek.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderedProductDTO extends AbstractDTO{

    private Long orderId;
    private Long productId;
    private BigDecimal quantity;
    private BigDecimal price;
    private int position;
}

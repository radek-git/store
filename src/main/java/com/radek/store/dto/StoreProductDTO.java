package com.radek.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreProductDTO extends AbstractDTO {

    private Long storeId;
    private Long productId;

    private BigDecimal quantity;
}

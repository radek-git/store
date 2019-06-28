package com.radek.store.dto;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreProductDTO extends AbstractDTO {

    private Long storeId;
    private Long productId;

    private BigDecimal quantity;
}

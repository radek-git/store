package com.radek.store.dto;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductDTO {

    private Long orderId;
    private Long productId;
    private BigDecimal quantity;
    private BigDecimal price;
    private int position;

}

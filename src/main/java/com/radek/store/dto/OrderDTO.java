package com.radek.store.dto;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO extends AbstractDTO{

    private Long customerId;

    private Long employeeId;

    private Long storeId;

    private BigDecimal totalPrice;
}

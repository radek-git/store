package com.radek.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO extends AbstractDTO{

    private Long customerId;

    private Long employeeId;

    private Long storeId;

    private BigDecimal totalPrice;
}

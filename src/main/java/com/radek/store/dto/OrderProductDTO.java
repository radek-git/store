package com.radek.store.dto;

import com.radek.store.dto.products.ProductDTO;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductDTO {

    private Long orderId;
    private ProductDTO product;
    private BigDecimal quantity;
    private BigDecimal price;
    private int position;

}

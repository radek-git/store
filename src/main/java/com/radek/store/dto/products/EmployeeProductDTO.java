package com.radek.store.dto.products;

import com.radek.store.dto.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeProductDTO extends AbstractDTO {


    private String name;
    private BigDecimal price;

    private Long categoryId;
    private Long brandId;
}

package com.radek.store.dto.products;

import com.radek.store.dto.AbstractDTO;
import com.radek.store.entity.Brand;
import com.radek.store.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AdminProductDTO extends AbstractDTO {

    private String name;
    private BigDecimal price;

    private Category category;
    private Brand brand;

    private Long addedByEmployeeId;
    private Long updatedByEmployeeId;

}

package com.radek.store.dto.brands;

import com.radek.store.dto.AbstractDTO;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BrandDTO {

    private Long id;
    private String name;

    public BrandDTO(String name) {
        this.name = name;
    }
}

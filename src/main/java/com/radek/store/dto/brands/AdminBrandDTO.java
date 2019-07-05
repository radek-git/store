package com.radek.store.dto.brands;

import com.radek.store.dto.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminBrandDTO  extends AbstractDTO {

    private String name;
}

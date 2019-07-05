package com.radek.store.dto.categories;

import com.radek.store.dto.AbstractDTO;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

    private Long id;
    private String name;
}

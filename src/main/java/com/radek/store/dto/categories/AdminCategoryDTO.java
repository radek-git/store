package com.radek.store.dto.categories;


import com.radek.store.dto.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AdminCategoryDTO extends AbstractDTO {

    private String name;
}

package com.radek.store.dto.stores;

import com.radek.store.dto.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminStoreDTO extends AbstractDTO {

    private String name;
    private String phoneNumber;
}

package com.radek.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreDTO extends AbstractDTO {

    private String name;
    private String phoneNumber;
}

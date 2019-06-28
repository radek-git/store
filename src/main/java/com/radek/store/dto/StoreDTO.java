package com.radek.store.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StoreDTO extends AbstractDTO {

    private String name;
    private String phoneNumber;
}

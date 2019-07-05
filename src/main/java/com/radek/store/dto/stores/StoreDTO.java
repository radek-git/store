package com.radek.store.dto.stores;

import com.radek.store.dto.AbstractDTO;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StoreDTO  {

    private Long id;
    private String name;
    private String phoneNumber;
}

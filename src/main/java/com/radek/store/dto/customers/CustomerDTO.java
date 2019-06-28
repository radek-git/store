package com.radek.store.dto.customers;

import com.radek.store.dto.AbstractDTO;
import com.radek.store.dto.users.UserDTO;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private Long id;
    private String name;
    private String surname;
    private String username;
    private int orders;


}

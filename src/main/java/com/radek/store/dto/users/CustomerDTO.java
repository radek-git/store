package com.radek.store.dto.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO extends UserDTO {


    private String street;
    private String city;
    private String postalCode;


}

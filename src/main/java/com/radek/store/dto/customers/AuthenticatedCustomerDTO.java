package com.radek.store.dto.customers;

import com.radek.store.dto.users.AuthenticatedUserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticatedCustomerDTO extends AuthenticatedUserDTO {

    private String street;
    private String city;
    private String postalCode;
    private int orders;

}

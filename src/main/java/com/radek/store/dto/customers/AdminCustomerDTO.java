package com.radek.store.dto.customers;

import com.radek.store.dto.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AdminCustomerDTO extends AbstractDTO {

    private String name;
    private String surname;
    private String username;
    private String street;
    private String city;
    private String postalCode;

    private Long addedByEmployeeId;

    private int orders;

    private boolean expired;
    private boolean locked;
    private boolean credentialsExpired;
    private boolean enabled;
}

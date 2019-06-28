package com.radek.store.dto.customers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCustomerDTO  {

    private Long id;
    private String name;
    private String surname;
    private String username;
    private String street;
    private String city;
    private String postalCode;
    private int orders;
}

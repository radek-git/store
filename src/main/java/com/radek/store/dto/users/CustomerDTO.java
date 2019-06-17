package com.radek.store.dto.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO extends UserDTO {


    @Builder
    public CustomerDTO(String name,  String surname, String username,
                    String email, String phoneNumber,
                    String street, String city, String postalCode) {
        super(name, surname, username, email, phoneNumber);
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }


    private String street;
    private String city;
    private String postalCode;


}

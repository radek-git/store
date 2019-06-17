package com.radek.store.dto.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO extends UserDTO {


    @Builder
    public EmployeeDTO(String name,  String surname, String username,
                       String email, String phoneNumber,
                       String street, String city, String postalCode) {
        super(name, surname, username, email, phoneNumber);
        this.storeId = storeId;
        this.positionId = positionId;

    }

    private Long storeId;
    private Long positionId;

}

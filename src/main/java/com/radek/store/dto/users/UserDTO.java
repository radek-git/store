package com.radek.store.dto.users;

import com.radek.store.dto.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends AbstractDTO {

    private String name;
    private String surname;
    private String username;
    private String email;
    private String phoneNumber;

}

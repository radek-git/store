package com.radek.store.dto.users;

import com.radek.store.dto.AbstractDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeUserDTO  {

    private Long id;
    private String name;
    private String surname;
    private String username;
    private String email;
    private String phoneNumber;
}

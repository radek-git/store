package com.radek.store.dto.employees;

import com.radek.store.dto.AbstractDTO;
import com.radek.store.dto.users.UserDTO;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO  {

    private Long id;
    private String name;
    private String surname;
    private String username;
    private Long storeId;
    private String position;

}

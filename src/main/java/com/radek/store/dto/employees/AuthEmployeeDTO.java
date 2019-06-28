package com.radek.store.dto.employees;

import com.radek.store.dto.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthEmployeeDTO  {

    private Long id;
    private String name;
    private String surname;
    private String username;
    private Long storeId;
    private String position;
    private Long addedByEmployeeId;
}

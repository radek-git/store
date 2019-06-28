package com.radek.store.dto.users;

import com.radek.store.dto.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticatedUserDTO  {

    private Long id;
    private String name;
    private String surname;
    private String username;
    private String email;
    private String phoneNumber;



}

package com.radek.store.dto.users;

import com.radek.store.dto.AbstractDTO;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdminUserDTO extends AbstractDTO {

    private String name;
    private String surname;
    private String username;
    private String email;
    private String phoneNumber;
    private boolean expired;
    private boolean locked;
    private boolean credentialsExpired;
    private boolean enabled;

}

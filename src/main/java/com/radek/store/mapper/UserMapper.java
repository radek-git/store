package com.radek.store.mapper;

import com.radek.store.dto.users.AdminUserDTO;
import com.radek.store.dto.users.AuthenticatedUserDTO;
import com.radek.store.dto.users.EmployeeUserDTO;
import com.radek.store.dto.users.UserDTO;
import com.radek.store.entity.users.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDTO(User user);

    List<UserDTO> toDTO(List<User> users);

    AdminUserDTO toAdminDTO(User user);

    List<AdminUserDTO> toAdminDTO(List<User> users);

    EmployeeUserDTO toEmployeeDTO(User user);

    List<EmployeeUserDTO> toEmployeeDTO(List<User> users);

    AuthenticatedUserDTO toAuthenticatedUserDTO(User user);


}

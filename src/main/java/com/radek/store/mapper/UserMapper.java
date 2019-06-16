package com.radek.store.mapper;

import com.radek.store.dto.users.UserDTO;
import com.radek.store.entity.users.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDTO(User user);

    List<UserDTO> toDTO(List<User> users);

    User toEntity(UserDTO userDTO);

    List<User> toEntity(List<UserDTO> userDTOS);

}

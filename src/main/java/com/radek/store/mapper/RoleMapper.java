package com.radek.store.mapper;

import com.radek.store.dto.RoleDTO;
import com.radek.store.entity.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDTO toDTO(Role role);

    List<RoleDTO> toDTO(List<Role> roles);

    Role toEntity(RoleDTO roleDTO);

    List<Role> toEntity(List<RoleDTO> roleDTOS);
}

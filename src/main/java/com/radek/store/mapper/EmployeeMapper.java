package com.radek.store.mapper;


import com.radek.store.dto.users.EmployeeDTO;
import com.radek.store.entity.users.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mappings({
            @Mapping(target = "storeId", source = "store.id"),
            @Mapping(target = "positionId", source = "position.id")
    })
    EmployeeDTO toDTO(Employee employee);

    List<EmployeeDTO> toDTO(List<Employee> employees);



}

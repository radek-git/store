package com.radek.store.mapper;


import com.radek.store.dto.employees.AdminEmployeeDTO;
import com.radek.store.dto.employees.AuthEmployeeDTO;
import com.radek.store.dto.employees.EmployeeDTO;
import com.radek.store.dto.employees.EmployeeEmployeeDTO;
import com.radek.store.entity.users.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mappings({
            @Mapping(target = "storeId", source = "store.id"),
            @Mapping(target = "position", source = "position.name")
    })
    EmployeeDTO toDTO(Employee employee);

    List<EmployeeDTO> toDTO(List<Employee> employees);


    @Mappings({
            @Mapping(target = "storeId", source = "store.id"),
            @Mapping(target = "position", source = "position.name"),
            @Mapping(target = "addedByEmployeeId", source = "employee.id")
    })
    AuthEmployeeDTO toAuthEmployeeDTO(Employee employee);


    @Mappings({
            @Mapping(target = "storeId", source = "store.id"),
            @Mapping(target = "position", source = "position.name"),
            @Mapping(target = "addedByEmployeeId", source = "employee.id")
    })
    AdminEmployeeDTO toAdminEmployeeDTO(Employee employee);

    List<AdminEmployeeDTO> toAdminEmployeeDTOList(List<Employee> employees);


    @Mappings({
            @Mapping(target = "storeId", source = "store.id"),
            @Mapping(target = "position", source = "position.name"),
            @Mapping(target = "addedByEmployeeId", source = "employee.id")
    })
    EmployeeEmployeeDTO toEmployeeEmployeeDTO(Employee employee);

    List<EmployeeEmployeeDTO> toEmployeeEmployeeDTOList(List<Employee> employees);

}

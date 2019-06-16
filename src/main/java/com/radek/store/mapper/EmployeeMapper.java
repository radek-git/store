package com.radek.store.mapper;


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
    EmployeeMapper toDTO(Employee employee);

    List<EmployeeMapper> toDTO(List<Employee> employees);

    Employee toEntity(EmployeeMapper employeeMapper);

    List<Employee> toEntity(List<EmployeeMapper> employeeMappers);

}

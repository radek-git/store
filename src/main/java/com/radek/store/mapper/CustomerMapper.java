package com.radek.store.mapper;

import com.radek.store.dto.customers.AdminCustomerDTO;
import com.radek.store.dto.customers.AuthenticatedCustomerDTO;
import com.radek.store.dto.customers.EmployeeCustomerDTO;
import com.radek.store.dto.customers.CustomerDTO;
import com.radek.store.entity.users.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {


    @Mappings({
            @Mapping(target = "orders", expression = "java(customer.getOrders().size())")
    })
    CustomerDTO toDTO(Customer customer);

    List<CustomerDTO> toDTO(List<Customer> customers);


    @Mappings({
            @Mapping(target = "addedByEmployeeId", source = "addedBy.id"),
            @Mapping(target = "orders", expression = "java(customer.getOrders().size())"),
    })
    AdminCustomerDTO toAdminCustomerDTO(Customer customer);

    List<AdminCustomerDTO> toAdminCustomerDTO(List<Customer> customers);

    @Mappings({
            @Mapping(target = "orders", expression = "java(customer.getOrders().size())"),
    })
    EmployeeCustomerDTO toEmployeeCustomerDTO(Customer customer);

    List<EmployeeCustomerDTO> toEmployeeCustomerDTO(List<Customer> customers);


    @Mappings({
            @Mapping(target = "orders", expression = "java(customer.getOrders().size())")
    })
    AuthenticatedCustomerDTO toAuthDTO(Customer customer);
}

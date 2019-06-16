package com.radek.store.mapper;

import com.radek.store.dto.users.CustomerDTO;
import com.radek.store.entity.users.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {



    CustomerDTO toDTO(Customer customer);

    List<CustomerDTO> toDTO(List<Customer> customers);

    Customer toEntity(CustomerDTO customerDTO);

    List<Customer> toEntity(List<CustomerDTO> customerDTOS);

}

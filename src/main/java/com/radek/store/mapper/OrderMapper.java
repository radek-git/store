package com.radek.store.mapper;

import com.radek.store.dto.OrderDTO;
import com.radek.store.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mappings({
            @Mapping(target = "customerId",source = "customer.id"),
            @Mapping(target = "employeeId", source = "employee.id"),
            @Mapping(target = "storeId", source = "store.id")
    })
    OrderDTO toDTO(Order order);

    List<OrderDTO> toDTO(List<Order> orders);



}

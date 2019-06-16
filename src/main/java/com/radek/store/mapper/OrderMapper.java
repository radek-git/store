package com.radek.store.mapper;

import com.radek.store.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mappings({
            @Mapping(target = "customerID",source = "customer.id"),
            @Mapping(target = "employeeId", source = "employee.id"),
            @Mapping(target = "storeId", source = "store.id")
    })
    OrderMapper toDTO(Order order);

    List<OrderMapper> toDTO(List<Order> orders);

    Order toEntity(OrderMapper orderMapper);

    List<Order> toEntity(List<OrderMapper> orderMappers);

}

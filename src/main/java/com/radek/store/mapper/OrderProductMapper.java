package com.radek.store.mapper;

import com.radek.store.dto.OrderProductDTO;
import com.radek.store.entity.OrderProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderProductMapper {


    @Mappings({
            @Mapping(target = "orderId", source = "order.id"),
            @Mapping(target = "productId", source = "product.id")
    })
    OrderProductDTO toDTO(OrderProduct orderProduct);

    List<OrderProductDTO> toDTO(List<OrderProduct> orderProducts);

    OrderProduct toEntity(OrderProductDTO orderProductDTO);

    List<OrderProduct> toEntity(List<OrderProductDTO> orderProductDTOS);
}

package com.radek.store.mapper;

import com.radek.store.dto.OrderedProductDTO;
import com.radek.store.entity.OrderProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderedProductMapper {


    @Mappings({
            @Mapping(target = "orderId", source = "order.id"),
            @Mapping(target = "productId", source = "product.id")
    })
    OrderedProductDTO toDTO(OrderProduct orderProduct);

    List<OrderedProductDTO> toDTO(List<OrderProduct> orderProducts);

    OrderProduct toEntity(OrderedProductDTO orderedProductDTO);

    List<OrderProduct> toEntity(List<OrderedProductDTO> orderedProductDTOS);
}

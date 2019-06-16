package com.radek.store.mapper;

import com.radek.store.dto.OrderedProductDTO;
import com.radek.store.entity.OrderedProduct;
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
    OrderedProductDTO toDTO(OrderedProduct orderedProduct);

    List<OrderedProductDTO> toDTO(List<OrderedProduct> orderedProducts);

    OrderedProduct toEntity(OrderedProductDTO orderedProductDTO);

    List<OrderedProduct> toEntity(List<OrderedProductDTO> orderedProductDTOS);
}

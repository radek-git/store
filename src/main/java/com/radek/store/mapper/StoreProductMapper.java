package com.radek.store.mapper;

import com.radek.store.dto.StoreProductDTO;
import com.radek.store.entity.StoreProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StoreProductMapper {

    @Mappings({
            @Mapping(target = "storeId", source = "store.id"),
            @Mapping(target = "productId", source = "product.id")
    })
    StoreProductDTO toDTO(StoreProduct storeProduct);

    List<StoreProductDTO> toDTO(List<StoreProduct> storeProducts);

    StoreProduct toEntity(StoreProductDTO storeProductDTO);

    List<StoreProduct> toEntity(List<StoreProductDTO> storeProductDTOS);


}

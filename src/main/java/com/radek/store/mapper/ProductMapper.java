package com.radek.store.mapper;

import com.radek.store.dto.ProductDTO;
import com.radek.store.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {


    @Mappings({
            @Mapping(target = "categoryId", source = "category.id"),
            @Mapping(target = "brandId", source = "brand.id")
    })
    ProductDTO toDTO(Product product);

    List<ProductDTO> toDTO(List<Product> product);

    Product toEntity(ProductDTO productDTO);

    List<Product> toEntity(List<ProductDTO> productDTOS);
}

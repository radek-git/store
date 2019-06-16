package com.radek.store.mapper;

import com.radek.store.dto.BrandDTO;
import com.radek.store.entity.Brand;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    BrandDTO toDTO(Brand brand);

    List<BrandDTO> toDTO(List<Brand> brands);

    Brand toEntity(BrandDTO brandDTO);

    List<Brand> brands(List<BrandDTO> brandDTOS);

}

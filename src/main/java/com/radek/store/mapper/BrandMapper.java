package com.radek.store.mapper;

import com.radek.store.dto.brands.AdminBrandDTO;
import com.radek.store.dto.brands.BrandDTO;
import com.radek.store.dto.brands.EmployeeBrandDTO;
import com.radek.store.entity.Brand;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    BrandDTO toDTO(Brand brand);

    List<BrandDTO> toDTO(List<Brand> brands);


    Brand toEntity(BrandDTO brandDTO);

    List<Brand> brands(List<BrandDTO> brandDTOS);

    AdminBrandDTO toAdminBrandDTO(Brand brand);

    List<AdminBrandDTO> toAdminBrandDTO(List<Brand> brands);

    EmployeeBrandDTO toEmployeeBrandDTO(Brand brand);

    List<EmployeeBrandDTO> toEmployeeBrandDTO(List<Brand> brands);

}

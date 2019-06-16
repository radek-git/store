package com.radek.store.mapper;


import com.radek.store.dto.StoreDTO;
import com.radek.store.entity.Store;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StoreMapper {

    StoreDTO toDTO(Store store);

    List<StoreDTO> toDTO(List<Store> stores);

    Store toEntity(StoreDTO storeDTO);

    List<Store> toEntity(List<StoreDTO> storeDTOS);

}

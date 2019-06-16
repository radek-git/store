package com.radek.store.mapper;

import com.radek.store.dto.PositionDTO;
import com.radek.store.entity.Position;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PositionMapper {

    PositionDTO toDTO(Position position);

    List<PositionDTO> toDTO(List<Position> positions);

    Position toEntity(PositionDTO positionDTO);

    List<Position> toEntity(List<PositionDTO> positionDTOS);

}

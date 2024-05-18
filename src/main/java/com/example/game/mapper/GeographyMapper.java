package com.example.game.mapper;

import com.example.game.domain.dtos.GeographyDTO;
import com.example.game.domain.entities.Geography;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GeographyMapper {
    GeographyMapper INSTANCE = Mappers.getMapper(GeographyMapper.class);

    Geography dtoToEntity(GeographyDTO dto);

    GeographyDTO entityToDto(Geography entity);
}

package com.example.game.mapper;

import com.example.game.domain.dtos.GamerDTO;
import com.example.game.domain.entities.Gamer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GamerMapper {
    GamerMapper INSTANCE = Mappers.getMapper(GamerMapper.class);

    @Mapping(target = "geography.id", source = "dto.geographyId")
    Gamer dtoToEntity(GamerDTO dto);

    @Mapping(target = "geographyId", source = "entity.geography.id")
    GamerDTO entityToDto(Gamer entity);
}

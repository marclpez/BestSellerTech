package com.example.game.mapper;

import com.example.game.domain.dtos.GameDTO;
import com.example.game.domain.entities.Game;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GameMapper {
    GameMapper INSTANCE = Mappers.getMapper(GameMapper.class);

    @Mapping(target = "geography.id", source = "dto.geographyId")
    Game dtoToEntity(GameDTO dto);

    @Mapping(target = "geographyId", source = "entity.geography.id")
    GameDTO entityToDto(Game entity);
}
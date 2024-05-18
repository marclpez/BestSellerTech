package com.example.game.mapper;

import com.example.game.domain.dtos.GamerGameDTO;
import com.example.game.domain.entities.GamerGame;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GamerGameMapper {
    GamerGameMapper INSTANCE = Mappers.getMapper(GamerGameMapper.class);

    @Mapping(target = "gamer.id", source = "dto.gamerId")
    @Mapping(target = "game.id", source = "dto.gameId")
    GamerGame dtoToEntity(GamerGameDTO dto);

    @Mapping(target = "gamerId", source = "entity.gamer.id")
    @Mapping(target = "gameId", source = "entity.game.id")
    GamerGameDTO entityToDto(GamerGame entity);
}
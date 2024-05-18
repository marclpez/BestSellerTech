package com.example.game.mapper;

import com.example.game.domain.dtos.GamerGameDTO;
import com.example.game.domain.entities.GamerGame;
import com.example.game.enums.Level;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GamerGameMapper {
    GamerGameMapper INSTANCE = Mappers.getMapper(GamerGameMapper.class);

    @Mapping(target = "gamer.id", source = "dto.gamerId")
    @Mapping(target = "game.id", source = "dto.gameId")
    @Mapping(target = "level", source = "dto.level", qualifiedByName = "toLevel")
    GamerGame dtoToEntity(GamerGameDTO dto);

    @Mapping(target = "gamerId", source = "entity.gamer.id")
    @Mapping(target = "gameId", source = "entity.game.id")
    @Mapping(target = "level", source = "entity.level", qualifiedByName = "toString")
    GamerGameDTO entityToDto(GamerGame entity);

    @Named("toLevel")
    default Level toLevel(String level) {
        return Level.valueOf(level.toUpperCase());
    }

    @Named("toString")
    default String toString(Level level) {
        return level.name();
    }
}
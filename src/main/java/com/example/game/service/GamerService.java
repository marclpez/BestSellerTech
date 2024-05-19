package com.example.game.service;

import com.example.game.domain.dtos.GamerDTO;
import com.example.game.domain.entities.Game;
import com.example.game.domain.entities.Gamer;
import com.example.game.enums.Level;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface GamerService {
    Gamer getGamerById(UUID id);

    List<GamerDTO> getGamersByLevelPerGame(Level level);

    List<GamerDTO> searchGamers(Level level, UUID gameId, UUID geographyId);
}

package com.example.game.service;

import com.example.game.domain.dtos.GamerDTO;
import com.example.game.domain.entities.Gamer;
import com.example.game.enums.Level;

import java.util.List;
import java.util.UUID;

public interface GamerService {
    Gamer getGamerById(UUID id);

    List<GamerDTO> getGamersByLevelAndGame(Level level, UUID gameId);
}

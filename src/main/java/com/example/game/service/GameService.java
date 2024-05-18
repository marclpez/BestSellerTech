package com.example.game.service;

import com.example.game.domain.entities.Game;

import java.util.UUID;

public interface GameService {
    Game getGameById(UUID id);
}

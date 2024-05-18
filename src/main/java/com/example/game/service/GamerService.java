package com.example.game.service;

import com.example.game.domain.entities.Gamer;

import java.util.UUID;

public interface GamerService {
    Gamer getGamerById(UUID id);
}

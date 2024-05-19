package com.example.game.service.impl;

import com.example.game.domain.entities.Game;
import com.example.game.repository.GameRepository;
import com.example.game.service.GameService;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }


    @Override
    public Game getGameById(UUID id){
        return gameRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Game not found with id: " + id));
    }

}

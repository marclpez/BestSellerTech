package com.example.game.service.impl;

import com.example.game.domain.entities.Game;
import com.example.game.repository.GameRepository;
import com.example.game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;


    @Override
    public Game getGameById(UUID id){
        return gameRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Game not found with id: " + id));
    }

}

package com.example.game.service.impl;

import com.example.game.domain.dtos.GamerGameDTO;
import com.example.game.domain.entities.Game;
import com.example.game.domain.entities.Gamer;
import com.example.game.mapper.GamerGameMapper;
import com.example.game.repository.GamerGameRepository;
import com.example.game.service.GameService;
import com.example.game.service.GamerGameService;
import com.example.game.service.GamerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;

@Slf4j
@Service
public class GamerGameServiceImpl implements GamerGameService {

    @Autowired
    private GamerGameRepository gamerGameRepository;

    @Autowired
    private GameService gameService;

    @Autowired
    private GamerService gamerService;

    @Override
    public void linkGamerToGame(GamerGameDTO gamerGameDTO) {
        try{
            //Verify if the game exists
            Game game = gameService.getGameById(gamerGameDTO.getGameId());

            //Verify if the gamer exists
            Gamer gamer = gamerService.getGamerById(gamerGameDTO.getGamerId());

            gamerGameRepository.save(GamerGameMapper.INSTANCE.dtoToEntity(gamerGameDTO));
        }catch(EntityNotFoundException e){
            log.error("Entity not found: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}

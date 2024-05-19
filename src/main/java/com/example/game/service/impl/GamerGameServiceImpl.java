package com.example.game.service.impl;

import com.example.game.domain.dtos.GamerGameDTO;
import com.example.game.domain.entities.Game;
import com.example.game.domain.entities.Gamer;
import com.example.game.domain.entities.GamerGame;
import com.example.game.enums.Level;
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
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class GamerGameServiceImpl implements GamerGameService {

    private final GamerGameRepository gamerGameRepository;

    private final GameService gameService;

    private final GamerService gamerService;

    public GamerGameServiceImpl(GamerGameRepository gamerGameRepository, GameService gameService, GamerService gamerService) {
        this.gamerGameRepository = gamerGameRepository;
        this.gameService = gameService;
        this.gamerService = gamerService;
    }

    @Override
    public void linkGamerToGame(GamerGameDTO gamerGameDTO) {

        // Check if a record already exists for the provided gameId and gamerId
        gamerGameRepository.findByGamerIdAndGameId(gamerGameDTO.getGamerId(), gamerGameDTO.getGameId())
                .ifPresent( gamerGame -> {
                    log.warn("Duplicate record: a GamerGame already exists for the provided gameId {} and gamerId {}", gamerGameDTO.getGameId(), gamerGameDTO.getGamerId());
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A record already exists for the provided gameId and gamerId");
                });

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

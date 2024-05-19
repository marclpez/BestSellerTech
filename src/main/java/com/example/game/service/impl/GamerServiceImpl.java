package com.example.game.service.impl;

import com.example.game.domain.dtos.GamerDTO;
import com.example.game.domain.entities.Game;
import com.example.game.domain.entities.Gamer;
import com.example.game.domain.entities.GamerGame;
import com.example.game.enums.Level;
import com.example.game.mapper.GamerMapper;
import com.example.game.repository.GamerRepository;
import com.example.game.service.GameService;
import com.example.game.service.GamerService;
import com.example.game.specification.GamerSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class GamerServiceImpl implements GamerService {


    private final GamerRepository gamerRepository;

    private final GameService gameService;

    private final GamerSpecification gamerSpecification;

    public GamerServiceImpl(GamerRepository gamerRepository, GameService gameService, GamerSpecification gamerSpecification) {
        this.gamerRepository = gamerRepository;
        this.gameService = gameService;
        this.gamerSpecification = gamerSpecification;
    }

    @Override
    public Gamer getGamerById(UUID id) {
        return gamerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Gamer not found with id: " + id));
    }

    @Override
    public List<GamerDTO> getGamersByLevelAndGame(Level level, UUID gameId) {
        try{
            Game game = gameService.getGameById(gameId);

            return gamerRepository.findGamersByLevelAndGame(level, game).stream()
                    .map(GamerMapper.INSTANCE::entityToDto)
                    .collect(Collectors.toList());
        } catch(EntityNotFoundException e){
            log.error("Entity not found: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @Override
    public List<GamerDTO> searchGamers(Level level, UUID gameId, UUID geographyId) {
        Specification<Gamer> specification = gamerSpecification.buildSpecification(level, gameId, geographyId);
        List<Gamer> gamerList = gamerRepository.findAll(specification);

        return gamerList.stream().map(GamerMapper.INSTANCE::entityToDto).collect(Collectors.toList());
    }
}

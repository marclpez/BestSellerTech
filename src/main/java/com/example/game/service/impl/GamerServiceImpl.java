package com.example.game.service.impl;

import com.example.game.domain.dtos.GamerDTO;
import com.example.game.domain.entities.Gamer;
import com.example.game.enums.Level;
import com.example.game.mapper.GamerMapper;
import com.example.game.repository.GamerRepository;
import com.example.game.service.GamerService;
import com.example.game.specification.GamerSpecification;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class GamerServiceImpl implements GamerService {


    private final GamerRepository gamerRepository;


    private final GamerSpecification gamerSpecification;

    public GamerServiceImpl(GamerRepository gamerRepository, GamerSpecification gamerSpecification) {
        this.gamerRepository = gamerRepository;
        this.gamerSpecification = gamerSpecification;
    }

    @Override
    public Gamer getGamerById(UUID id) {
        return gamerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Gamer not found with id: " + id));
    }

    @Override
    public List<GamerDTO> getGamersByLevelPerGame(Level level) {
        return gamerRepository.findGamersByLevel(level).stream().map(GamerMapper.INSTANCE::entityToDto).collect(Collectors.toList());
    }

    @Override
    public List<GamerDTO> searchGamers(Level level, UUID gameId, UUID geographyId) {
        Specification<Gamer> specification = gamerSpecification.buildSpecification(level, gameId, geographyId);
        List<Gamer> gamerList = gamerRepository.findAll(specification);

        return gamerList.stream().map(GamerMapper.INSTANCE::entityToDto).collect(Collectors.toList());
    }
}

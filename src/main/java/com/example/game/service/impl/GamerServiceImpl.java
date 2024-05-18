package com.example.game.service.impl;

import com.example.game.domain.entities.Gamer;
import com.example.game.repository.GamerRepository;
import com.example.game.service.GamerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
public class GamerServiceImpl implements GamerService {

    @Autowired
    private GamerRepository gamerRepository;

    @Override
    public Gamer getGamerById(UUID id) {
        return gamerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Gamer not found with id: " + id));
    }
}

package com.example.game.service;

import com.example.game.domain.dtos.GamerGameDTO;
import com.example.game.domain.entities.Game;
import com.example.game.domain.entities.GamerGame;
import com.example.game.enums.Level;

import java.util.List;

public interface GamerGameService {

    void linkGamerToGame(GamerGameDTO gamerGameDTO);

}

package com.example.game.controller;


import com.example.game.domain.dtos.GamerGameDTO;
import com.example.game.service.GamerGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping("/api/v1/gamerGame")
public class GamerGameController {

    @Autowired
    private GamerGameService gamerGameService;

    @PostMapping
    public ResponseEntity<Void> linkGamerToGame(@Valid @RequestBody GamerGameDTO gamerGameDTO) {
        gamerGameService.linkGamerToGame(gamerGameDTO);
        return ResponseEntity.ok().build();
    }
}

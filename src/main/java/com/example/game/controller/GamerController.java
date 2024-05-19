package com.example.game.controller;

import com.example.game.domain.dtos.GamerDTO;
import com.example.game.domain.entities.Game;
import com.example.game.domain.entities.Gamer;
import com.example.game.enums.Level;
import com.example.game.service.GamerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/gamer")
public class GamerController {

    private final GamerService gamerService;

    public GamerController(GamerService gamerService) {
        this.gamerService = gamerService;
    }

    @GetMapping("/level/{level}")
    public ResponseEntity<List<GamerDTO>> getGamersByLevelPerGame(@PathVariable Level level) {
        List<GamerDTO> gamersByGame = gamerService.getGamersByLevelPerGame(level);
        return ResponseEntity.ok(gamersByGame);
    }

    @GetMapping("/search")
    public ResponseEntity<List<GamerDTO>> searchGamers(
            @RequestParam(required = false) Level level,
            @RequestParam(required = false) UUID gameId,
            @RequestParam(required = false) UUID geographyId) {
        List<GamerDTO> gamers = gamerService.searchGamers(level, gameId, geographyId);
        return ResponseEntity.ok(gamers);
    }
}

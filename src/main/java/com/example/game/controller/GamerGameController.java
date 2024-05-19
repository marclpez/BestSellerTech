package com.example.game.controller;


import com.example.game.domain.dtos.GamerGameDTO;
import com.example.game.service.GamerGameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping("/api/v1/gamerGame")
@Tag(name = "Gamer Game API", description = "API for managing gamer-game relationships")
public class GamerGameController {

    @Autowired
    private GamerGameService gamerGameService;

    @PostMapping
    @Operation(summary = "Link a gamer to a game", description = "Creates a relationship between a gamer and a game")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully linked the gamer to the game"),
            @ApiResponse(responseCode = "400", description = "Invalid request payload",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Gamer or game not found",
                    content = @Content)
    })
    public ResponseEntity<Void> linkGamerToGame(
            @Valid @RequestBody @Parameter(description = "Gamer-game relationship details") GamerGameDTO gamerGameDTO) {
        gamerGameService.linkGamerToGame(gamerGameDTO);
        return ResponseEntity.ok().build();
    }
}
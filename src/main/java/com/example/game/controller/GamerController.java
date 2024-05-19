package com.example.game.controller;

import com.example.game.domain.dtos.GamerDTO;
import com.example.game.enums.Level;
import com.example.game.service.GamerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/gamer")
@Tag(name = "Gamer API", description = "API for managing gamers")
public class GamerController {

    private final GamerService gamerService;

    public GamerController(GamerService gamerService) {
        this.gamerService = gamerService;
    }

    @GetMapping("/level/{level}")
    @Operation(summary = "Get gamers by level per game", description = "Retrieves a list of gamers based on the specified level per game")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved gamers",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = GamerDTO.class))),
            @ApiResponse(responseCode = "404", description = "Gamers not found for the specified level",
                    content = @Content)
    })
    public ResponseEntity<List<GamerDTO>> getGamersByLevelPerGame(
            @PathVariable(value = "level") @Parameter(description = "Level of the gamers") Level level) {
        List<GamerDTO> gamersByGame = gamerService.getGamersByLevelPerGame(level);
        return ResponseEntity.ok(gamersByGame);
    }

    @GetMapping("/search")
    @Operation(summary = "Search gamers", description = "Searches for gamers based on optional criteria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved gamers",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = GamerDTO.class))),
            @ApiResponse(responseCode = "404", description = "No gamers found for the specified criteria",
                    content = @Content)
    })
    public ResponseEntity<List<GamerDTO>> searchGamers(
            @RequestParam(required = false) @Parameter(description = "Level of the gamers") Level level,
            @RequestParam(required = false) @Parameter(description = "ID of the game") UUID gameId,
            @RequestParam(required = false) @Parameter(description = "ID of the geography") UUID geographyId) {
        List<GamerDTO> gamers = gamerService.searchGamers(level, gameId, geographyId);
        return ResponseEntity.ok(gamers);
    }
}

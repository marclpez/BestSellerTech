package com.example.game.domain.dtos;

import com.example.game.domain.entities.GamerGame;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Data
public class GameDTO {
    private UUID id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    private String description;

    @NotNull(message = "Geography ID is mandatory")
    private UUID geographyId;

    private List<GamerGame> gamers;
}
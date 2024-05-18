package com.example.game.domain.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class GamerGameDTO {
    @NotNull(message = "Gamer ID is mandatory")
    private UUID gamerId;

    @NotNull(message = "Game ID is mandatory")
    private UUID gameId;

    @NotBlank(message = "Level is mandatory")
    private String level;
}

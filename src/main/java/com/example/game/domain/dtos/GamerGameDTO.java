package com.example.game.domain.dtos;


import com.example.game.enums.Level;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class GamerGameDTO {
    @NotNull(message = "Gamer ID is mandatory")
    private UUID gamerId;

    @NotNull(message = "Game ID is mandatory")
    private UUID gameId;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Level is mandatory")
    private Level level;
}

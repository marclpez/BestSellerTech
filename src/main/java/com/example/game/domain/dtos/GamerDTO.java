package com.example.game.domain.dtos;


import com.example.game.domain.entities.GamerGame;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Data
public class GamerDTO {
    private UUID id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Geography ID is mandatory")
    private UUID geographyId;

    private List<GamerGame> games;
}
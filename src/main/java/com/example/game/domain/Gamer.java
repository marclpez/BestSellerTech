package com.example.game.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "GAMER")
public class Gamer {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    private String name;

    private String geography;

    @ManyToMany
    @JoinTable(
            name = "gamer_game",
            joinColumns = @JoinColumn(name = "gamer_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id")
    )
    private List<Game> games;
}

package com.example.game.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "GAME")
public class Game {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @ManyToMany(mappedBy = "games")
    private List<Gamer> gamers;

    @ManyToOne
    @JoinColumn(name = "geography_id")
    private Geography geography;
}

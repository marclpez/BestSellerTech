package com.example.game.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "GAME")
public class Game {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    private String name;
    private String description;

    @ManyToMany(mappedBy = "games")
    private List<Gamer> gamers;

    @ManyToOne
    @JoinColumn(name = "geography_id")
    private Geography geography;
}

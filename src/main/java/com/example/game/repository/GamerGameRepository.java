package com.example.game.repository;

import com.example.game.domain.entities.GamerGame;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GamerGameRepository extends JpaRepository<GamerGame, UUID> {
}

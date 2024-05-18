package com.example.game.repository;

import com.example.game.domain.entities.Gamer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GamerRepository extends JpaRepository<Gamer, UUID> {
}

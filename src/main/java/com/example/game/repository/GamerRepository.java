package com.example.game.repository;

import com.example.game.domain.entities.Gamer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GamerRepository extends JpaRepository<Gamer, UUID> {
}

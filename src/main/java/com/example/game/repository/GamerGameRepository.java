package com.example.game.repository;

import com.example.game.domain.entities.Game;
import com.example.game.domain.entities.Gamer;
import com.example.game.domain.entities.GamerGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GamerGameRepository extends JpaRepository<GamerGame, UUID> {

    Optional<GamerGame> findByGamerIdAndGameId(UUID gamer, UUID game);
}

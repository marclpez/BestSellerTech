package com.example.game.repository;

import com.example.game.domain.entities.Game;
import com.example.game.domain.entities.Gamer;
import com.example.game.domain.entities.GamerGame;
import com.example.game.enums.Level;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface GamerGameRepository extends JpaRepository<GamerGame, UUID>, JpaSpecificationExecutor<GamerGame> {

    Optional<GamerGame> findByGamerIdAndGameId(UUID gamer, UUID game);

    List<GamerGame> findByLevelAndGame(Level level, Game game);
}

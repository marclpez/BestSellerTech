package com.example.game.repository;

import com.example.game.domain.entities.Game;
import com.example.game.domain.entities.Gamer;
import com.example.game.enums.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GamerRepository extends JpaRepository<Gamer, UUID>, JpaSpecificationExecutor<Gamer> {
    @Query("SELECT g FROM GamerGame gg JOIN gg.gamer g WHERE gg.level = :level GROUP BY gg.gamer")
    List<Gamer> findGamersByLevel(Level level);
}
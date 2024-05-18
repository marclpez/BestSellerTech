package com.example.game.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GamerGameRepository extends JpaRepository<GamerGameRepository, UUID> {
}

package com.example.game.repository;

import com.example.game.domain.Geography;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GeographyRepository extends JpaRepository<Geography, UUID> {
}

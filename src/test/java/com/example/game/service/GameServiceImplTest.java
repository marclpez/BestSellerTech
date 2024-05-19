package com.example.game.service;

import com.example.game.domain.entities.Game;
import com.example.game.repository.GameRepository;
import com.example.game.service.impl.GameServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GameServiceImplTest {

    @Mock
    private GameRepository gameRepository;

    @InjectMocks
    private GameServiceImpl gameService;

    @Test
    void getGameById_OK() {
        // Arrange
        UUID gameId = UUID.randomUUID();
        Game game = new Game();
        game.setId(gameId);

        when(gameRepository.findById(gameId)).thenReturn(Optional.of(game));

        // Act
        Game result = gameService.getGameById(gameId);

        // Assert
        assertNotNull(result);
        assertEquals(gameId, result.getId());
        verify(gameRepository, times(1)).findById(gameId);
    }

    @Test
    void getGameById_KO_GameNotFound() {
        // Arrange
        UUID gameId = UUID.randomUUID();

        when(gameRepository.findById(gameId)).thenReturn(Optional.empty());

        // Act & Assert
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> {
            gameService.getGameById(gameId);
        });

        assertEquals("Game not found with id: " + gameId, exception.getMessage());
        verify(gameRepository, times(1)).findById(gameId);
    }
}
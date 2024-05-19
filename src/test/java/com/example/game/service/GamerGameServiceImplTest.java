package com.example.game.service;

import com.example.game.domain.dtos.GamerGameDTO;
import com.example.game.domain.entities.Game;
import com.example.game.domain.entities.Gamer;
import com.example.game.domain.entities.GamerGame;
import com.example.game.enums.Level;
import com.example.game.repository.GamerGameRepository;
import com.example.game.service.impl.GamerGameServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GamerGameServiceImplTest {

    @Mock
    private GamerGameRepository gamerGameRepository;

    @Mock
    private GameService gameService;

    @Mock
    private GamerService gamerService;

    @InjectMocks
    private GamerGameServiceImpl gamerGameService;

    @Test
    void linkGamerToGame_OK() {
        // Arrange
        GamerGameDTO gamerGameDTO = new GamerGameDTO();
        gamerGameDTO.setGamerId(UUID.randomUUID());
        gamerGameDTO.setGameId(UUID.randomUUID());
        gamerGameDTO.setLevel(Level.INVINCIBLE);

        Game game = new Game();
        Gamer gamer = new Gamer();

        when(gamerGameRepository.findByGamerIdAndGameId(gamerGameDTO.getGamerId(), gamerGameDTO.getGameId()))
                .thenReturn(Optional.empty());
        when(gameService.getGameById(gamerGameDTO.getGameId())).thenReturn(game);
        when(gamerService.getGamerById(gamerGameDTO.getGamerId())).thenReturn(gamer);

        // Act
        gamerGameService.linkGamerToGame(gamerGameDTO);

        // Assert
        verify(gamerGameRepository, times(1)).save(any(GamerGame.class));
    }

    @Test
    void linkGamerToGame_KO_DuplicateRecord() {
        // Arrange
        GamerGameDTO gamerGameDTO = new GamerGameDTO();
        gamerGameDTO.setGamerId(UUID.randomUUID());
        gamerGameDTO.setGameId(UUID.randomUUID());
        gamerGameDTO.setLevel(Level.INVINCIBLE);

        GamerGame existingGamerGame = new GamerGame();

        when(gamerGameRepository.findByGamerIdAndGameId(gamerGameDTO.getGamerId(), gamerGameDTO.getGameId()))
                .thenReturn(Optional.of(existingGamerGame));

        // Act & Assert
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            gamerGameService.linkGamerToGame(gamerGameDTO);
        });

        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
        assertEquals("A record already exists for the provided gameId and gamerId", exception.getReason());
        verify(gamerGameRepository, never()).save(any(GamerGame.class));
    }

    @Test
    void linkGamerToGame_KO_GameNotFound() {
        // Arrange
        GamerGameDTO gamerGameDTO = new GamerGameDTO();
        gamerGameDTO.setGamerId(UUID.randomUUID());
        gamerGameDTO.setGameId(UUID.randomUUID());
        gamerGameDTO.setLevel(Level.INVINCIBLE);

        when(gamerGameRepository.findByGamerIdAndGameId(gamerGameDTO.getGamerId(), gamerGameDTO.getGameId()))
                .thenReturn(Optional.empty());
        when(gameService.getGameById(gamerGameDTO.getGameId())).thenThrow(new EntityNotFoundException("Game not found"));

        // Act & Assert
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> {
            gamerGameService.linkGamerToGame(gamerGameDTO);
        });

        assertEquals("Game not found", exception.getMessage());
        verify(gamerGameRepository, never()).save(any(GamerGame.class));
    }

}
package com.example.game.service;

import com.example.game.domain.dtos.GamerDTO;
import com.example.game.domain.entities.Gamer;
import com.example.game.enums.Level;
import com.example.game.repository.GamerRepository;
import com.example.game.service.impl.GamerServiceImpl;
import com.example.game.specification.GamerSpecification;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GamerServiceImplTest {

    @Mock
    private GamerRepository gamerRepository;

    @Mock
    private GamerSpecification gamerSpecification;

    @InjectMocks
    private GamerServiceImpl gamerService;

    @Test
    public void getGamerById_OK() {
        // Arrange
        UUID gamerId = UUID.randomUUID();
        Gamer gamer = new Gamer();
        gamer.setId(gamerId);

        when(gamerRepository.findById(gamerId)).thenReturn(Optional.of(gamer));

        // Act
        Gamer result = gamerService.getGamerById(gamerId);

        // Assert
        assertNotNull(result);
        assertEquals(gamerId, result.getId());
        verify(gamerRepository, times(1)).findById(gamerId);
    }

    @Test
    public void getGamerById_KO_GamerNotFound() {
        // Arrange
        UUID gamerId = UUID.randomUUID();

        when(gamerRepository.findById(gamerId)).thenReturn(Optional.empty());

        // Act & Assert
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> {
            gamerService.getGamerById(gamerId);
        });

        assertEquals("Gamer not found with id: " + gamerId, exception.getMessage());
        verify(gamerRepository, times(1)).findById(gamerId);
    }

    @Test
    public void getGamersByLevelPerGame_OK() {
        // Arrange
        Level level = Level.INVINCIBLE;
        List<Gamer> gamerList = new ArrayList<>();
        gamerList.add(new Gamer());
        gamerList.add(new Gamer());

        when(gamerRepository.findGamersByLevel(level)).thenReturn(gamerList);

        // Act
        List<GamerDTO> result = gamerService.getGamersByLevelPerGame(level);

        // Assert
        assertNotNull(result);
        assertEquals(gamerList.size(), result.size());
        verify(gamerRepository, times(1)).findGamersByLevel(level);
    }

    @Test
    public void searchGamers_OK() {
        // Arrange
        Level level = Level.PRO;
        UUID gameId = UUID.randomUUID();
        UUID geographyId = UUID.randomUUID();
        List<Gamer> gamerList = new ArrayList<>();
        gamerList.add(new Gamer());
        gamerList.add(new Gamer());

        Specification<Gamer> specification = mock(Specification.class);
        when(gamerSpecification.buildSpecification(level, gameId, geographyId)).thenReturn(specification);
        when(gamerRepository.findAll(specification)).thenReturn(gamerList);

        // Act
        List<GamerDTO> result = gamerService.searchGamers(level, gameId, geographyId);

        // Assert
        assertNotNull(result);
        assertEquals(gamerList.size(), result.size());
        verify(gamerSpecification, times(1)).buildSpecification(level, gameId, geographyId);
        verify(gamerRepository, times(1)).findAll(specification);
    }
}
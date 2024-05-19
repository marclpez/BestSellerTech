package com.example.game.specification;

import com.example.game.domain.entities.Gamer;
import com.example.game.domain.entities.GamerGame;
import com.example.game.enums.Level;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class GamerSpecification {

    public Specification<Gamer> buildSpecification(Level level, UUID gameId, UUID geographyId) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Agregar condiciones de búsqueda basadas en los parámetros proporcionados
            if (level != null) {
                Join<Gamer, GamerGame> gamerGameJoin = root.join("games");
                predicates.add(criteriaBuilder.equal(gamerGameJoin.get("level"), level));
            }
            if (gameId != null) {
                Join<Gamer, GamerGame> gamerGameJoin = root.join("games");
                predicates.add(criteriaBuilder.equal(gamerGameJoin.get("game").get("id"), gameId));
            }
            if (geographyId != null) {
                predicates.add(criteriaBuilder.equal(root.get("geography").get("id"), geographyId));
            }

            // Combina todas las condiciones con una conjunción "AND"
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

}

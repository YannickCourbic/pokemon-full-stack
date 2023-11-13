package com.pokemonapi.restpokemon.Repository;

import com.pokemonapi.restpokemon.Entity.Generation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GenerationRepository extends JpaRepository<Generation , Long> {

    Boolean existsByRegion(String region);
}

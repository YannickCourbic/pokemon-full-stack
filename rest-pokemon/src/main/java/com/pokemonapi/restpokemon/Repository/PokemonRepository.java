package com.pokemonapi.restpokemon.Repository;

import com.pokemonapi.restpokemon.Entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon , Long> {
}

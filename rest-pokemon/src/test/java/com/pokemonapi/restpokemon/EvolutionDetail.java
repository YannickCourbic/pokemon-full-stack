package com.pokemonapi.restpokemon;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class EvolutionDetail {
    private int pokedexId;
    private String name;
    private String condition;
}

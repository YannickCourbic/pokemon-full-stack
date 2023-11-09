package com.pokemonapi.restpokemon;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
@Data

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonList {
    private List<PokemonJson> pokemonList;
}

package com.pokemonapi.restpokemon;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class SexeJson {
    private double male;
    private double female;
}

package com.pokemonapi.restpokemon;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TalentJson {
    private String name;
    private String image;

    // Getters and setters
}
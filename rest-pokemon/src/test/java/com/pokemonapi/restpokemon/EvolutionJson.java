package com.pokemonapi.restpokemon;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class EvolutionJson {
    private List<EvolutionDetail> pre;
    private List<EvolutionDetail> next;
    private List<EvolutionDetail> mega;
}

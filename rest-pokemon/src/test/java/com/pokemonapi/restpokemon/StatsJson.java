package com.pokemonapi.restpokemon;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class StatsJson {
    private Integer hp;
    private Integer atk;
    private Integer def;
    private Integer spe_atk;
    private Integer spe_def;
    private Integer vit;
}

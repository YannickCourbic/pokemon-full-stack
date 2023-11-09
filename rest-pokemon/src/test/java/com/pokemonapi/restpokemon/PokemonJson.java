package com.pokemonapi.restpokemon;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
import java.util.Map;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonJson {
    private int pokedexId;
    private int generation;
    private String category;
    private Map<String, String> name;
    private Map<String, String> sprites;
    private List<TypeJson> types;
    private List<TalentJson> talents;
    private StatsJson stats;
    private List<ResistanceJson> resistances;
    private EvolutionJson evolution;
    private String height;
    private String weight;
    private List<String> eggGroups;
    private SexeJson sexe;
    private int catchRate;
    private int level100;
    private String forme;

    // Getters and setters
}

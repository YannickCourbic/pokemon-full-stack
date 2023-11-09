package com.pokemonapi.restpokemon.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
@Data
@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Generation generation;
    private String category;
    @ElementCollection
    private HashMap<String , String> name;
    @ElementCollection
    private HashMap<String , String> sprites;
    @ElementCollection
    private List<String> types;
    @ElementCollection
    private HashMap<String , Long> stats;
    @ElementCollection
    private HashMap<String, Object> resistances;
    @ElementCollection
    private HashMap<String , Object> evolution;
    private String height;
    private String weight;
    @ElementCollection
    private List<String> egg_groups;
    @ElementCollection
    private HashMap<String , Long> sexe;
    private Long catchRate;
}

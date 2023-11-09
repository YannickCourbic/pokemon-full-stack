package com.pokemonapi.restpokemon.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Generation generation;
    private String category;
    @Column(columnDefinition = "json")
    private String name;
    @Column(columnDefinition = "json")
    private String sprites;
    @Column(columnDefinition = "json")
    private String types;
    @Column(columnDefinition = "json")
    private String stats;
    @Column(columnDefinition = "json")
    private String resistances;
    @Column(columnDefinition = "json")
    private String evolution;
    private String height;
    private String weight;
    @Column(columnDefinition = "json")
    private String egg_groups;
    @Column(columnDefinition = "json")
    private String sexe;
    private Long catchRate;
}

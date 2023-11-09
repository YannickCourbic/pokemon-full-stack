package com.pokemonapi.restpokemon.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Generation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "La région ne peut être vide!")
    @NotNull(message = "la région ne peut être null!")
    @Size(min = 2 , message= "le champ région doit avoir au minimum 2 caractères")
    private String region;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "generation")
    private List<Pokemon> pokemonList;
}

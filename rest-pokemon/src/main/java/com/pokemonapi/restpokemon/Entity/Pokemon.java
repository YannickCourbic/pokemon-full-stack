package com.pokemonapi.restpokemon.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long pokedexId;
    @ManyToOne
    @NotNull
    @JsonManagedReference  // Indique que la sérialisation se fait à partir de cette référence
    private Generation generation;
    @NotNull(message = "la catégorie ne peut être null.")
    @NotEmpty(message = "la catégorie ne peut être vide.")
    @Size(min = 2 , message = "la catégorie doit avoir un minimum 2 caractères")
    private String category;
    @Column(columnDefinition = "json")
    // Ignorer la sérialisation de la propriété generation pour éviter une boucle infinie
    @NotEmpty(message = "le nom ne peut être vide")
    @NotNull(message = "le nom ne peut être null")
    private String name;
    @Column(columnDefinition = "json")
    @NotEmpty(message = "le sprite ne peut être vide")
    @NotNull(message = "le sprite ne peut être null")
    private String sprites;
    @Column(columnDefinition = "json")
    @NotEmpty(message = "le type ne peut être vide")
    @NotNull(message = "le type ne peut être null")
    private String types;
    @Column(columnDefinition = "json")
    @NotEmpty(message = "les stats ne peut être vide")
    @NotNull(message = "les stats ne peut être null")
    private String stats;
    @Column(columnDefinition = "json")
    @NotEmpty(message = "les résistances ne peut être vide")
    @NotNull(message = "les résistances ne peut être null")
    private String resistances;
    @Column(columnDefinition = "json")
    private String evolution;
    @NotEmpty(message = "la hauteur ne peut être vide")
    @NotNull(message = "la hauteur ne peut être null")
    private String height;
    @NotEmpty(message = "le poids ne peut être vide")
    @NotNull(message = "le poids ne peut être null")
    private String weight;
    @NotEmpty(message = "le group d'oeuf ne peut être vide")
    @NotNull(message = "le group d'oeuf ne peut être null")
    @Column(columnDefinition = "json")
    private String egg_groups;
    @Column(columnDefinition = "json")
    @NotEmpty(message = "le sexe ne peut être vide")
    @NotNull(message = "le sexe ne peut être null")
    private String sexe;
    private Long catchRate;
    private Long level100;

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", pokedexId=" + pokedexId +
                ", category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", sprites='" + sprites + '\'' +
                ", types='" + types + '\'' +
                ", stats='" + stats + '\'' +
                ", resistances='" + resistances + '\'' +
                ", evolution='" + evolution + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", egg_groups='" + egg_groups + '\'' +
                ", sexe='" + sexe + '\'' +
                ", catchRate=" + catchRate +
                ", level100=" + level100 +
                '}';
    }
}

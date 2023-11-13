package com.pokemonapi.restpokemon.Service;

import com.pokemonapi.restpokemon.Entity.Pokemon;

import java.util.List;

public interface PokemonService {
    Object createPokemon(Pokemon pokemon);
    Object updatedPokemon(Pokemon pokemon);
    Pokemon getPokemon(Pokemon pokemon);
    Pokemon getPokemonById(Long id);
    List<Pokemon> getAllPokemon();
    List<Pokemon> getPokemonsByPokedexId(Long id);
    List<Pokemon> getSearchPokemon(String search);
    List<Pokemon> getTypePokemon(String type);
    List<Pokemon> getPokemonsByCategory(String category);
    List<Pokemon> getPokemonBase();
    List<Pokemon> getPaginated( Long limit , Long offset );
    List<Pokemon> findByName(String name);
    List<Pokemon> findByStade1();
    List<Pokemon> findByStade2();
    List <Pokemon> getPokemonsByNotEvolution();
    List<Pokemon> getPokemonsByLegend();


}

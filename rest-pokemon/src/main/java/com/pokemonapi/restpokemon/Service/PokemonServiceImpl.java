package com.pokemonapi.restpokemon.Service;

import com.pokemonapi.restpokemon.Entity.Generation;
import com.pokemonapi.restpokemon.Entity.Pokemon;
import com.pokemonapi.restpokemon.Repository.PokemonRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Transactional
@RequiredArgsConstructor
public class PokemonServiceImpl implements PokemonService {

    private final PokemonRepository pokemonRepository;
    private final  static String mes = "message";
    @Override
    public Object createPokemon(Pokemon pokemon) {
        Map<String , Object> res = new HashMap<>();
        try{
            res.put( mes , "Vous avez crée avec succès un pokémon ");
            res.put("generation" , this.pokemonRepository.save(pokemon));
            return res;
        }catch (Exception e){
            e.printStackTrace();
            res.put(mes , "Une erreur est survenu...");
            return res;
        }
    }

    @Override
    public Object updatedPokemon(Pokemon pokemon) {
        Map<String , Object> res = new HashMap<>();
        try{
            res.put(mes , "Vous avez modifiée avec succès un pokémon ");
            res.put("generation" , this.pokemonRepository.save(pokemon));
            return res;
        }catch (Exception e){
            e.printStackTrace();
            res.put(mes , "Une erreur est survenu...");
            return res;
        }
    }

    @Override
    public Pokemon getPokemon(Pokemon pokemon) {
        Optional<Pokemon> optionalPokemon = this.pokemonRepository.findById(pokemon.getId());
        return optionalPokemon.orElse(null);
    }

    @Override
    public Pokemon getPokemonById(Long id) {
        Optional<Pokemon> optionalPokemon = this.pokemonRepository.findById(id);
        return optionalPokemon.orElse(null);
    }

    @Override
    public List<Pokemon> getAllPokemon() {
        return  this.pokemonRepository.findAll();
    }

    @Override
    public List<Pokemon> getPokemonsByPokedexId(Long id) {
        return !this.pokemonRepository.getPokemonsByPokedexId(id).isEmpty() ? this.pokemonRepository.getPokemonsByPokedexId(id) : null;
    }

    @Override
    public List<Pokemon> getSearchPokemon(String search) {
        return !this.pokemonRepository.searchByPokemon(search).isEmpty()? this.pokemonRepository.searchByPokemon(search) : null;
    }

    @Override
    public List<Pokemon> getTypePokemon(String type) {
        return !this.pokemonRepository.searchByTypes(type).isEmpty() ? this.pokemonRepository.searchByTypes(type) : null;
    }

    @Override
    public List<Pokemon> getPokemonsByCategory(String category) {
        return !this.pokemonRepository.getPokemonsByCategory(category).isEmpty() ? this.pokemonRepository.getPokemonsByCategory(category) : null;
    }

    @Override
    public List<Pokemon> getPokemonBase() {
        return !this.pokemonRepository.getPokemonBase().isEmpty() ? this.pokemonRepository.getPokemonBase() : null;
    }

    @Override
    public List<Pokemon> getPaginated( Long limit , Long offset) {
        return !this.pokemonRepository.getPaginated(limit , offset).isEmpty() ? this.pokemonRepository.getPaginated(limit, offset) : null;
    }

    @Override
    public List<Pokemon> findByName(String name) {
        return !this.pokemonRepository.findByName(name).isEmpty() ?this.pokemonRepository.findByName(name) : null;
    }

    @Override
    public List<Pokemon> findByStade1() {
        List<Pokemon> pokemons = !this.pokemonRepository.getPokemonStade1().isEmpty() ? this.pokemonRepository.getPokemonStade1() : null;
        return pokemons;
    }

    @Override
    public List<Pokemon> findByStade2() {
        return !this.pokemonRepository.getPokemonsStade2().isEmpty() ? this.pokemonRepository.getPokemonsStade2() : null;
    }

    @Override
    public List<Pokemon> getPokemonsByNotEvolution() {
        return !this.pokemonRepository.getPokemonsByNotEvolution().isEmpty() ? this.pokemonRepository.getPokemonsByNotEvolution() : null;
    }

    @Override
    public List<Pokemon> getPokemonsByLegend() {
        return !this.pokemonRepository.getPokemonsByLengend().isEmpty() ? this.pokemonRepository.getPokemonsByLengend() : null;
    }

}

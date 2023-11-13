package com.pokemonapi.restpokemon.Repository;

import com.pokemonapi.restpokemon.Entity.Pokemon;
import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PokemonRepository extends JpaRepository<Pokemon , Long> {
    @Query("select p from Pokemon  p where p.pokedexId = :id")
    List<Pokemon> getPokemonsByPokedexId(@Param("id") Long id);
    @Query(value = "SELECT * FROM pokemon WHERE name->>'$.fr' LIKE %:search% order by pokedex_id", nativeQuery = true)
    List<Pokemon> searchByPokemon(@Param("search") String search);
    @Query(value = "SELECT * FROM pokemon WHERE name->>'$.fr' = :name", nativeQuery = true)
    List<Pokemon> findByName(@Param("name") String name);
    @Query(value = "SELECT * FROM pokemon where types->>'$[0].name' LIKE %:types% order by pokedex_id" , nativeQuery = true)
    List<Pokemon> searchByTypes(@Param("types") String type);
    @Query("select p from Pokemon p where p.category = :category")
    List<Pokemon> getPokemonsByCategory(@Param("category") String category);
    @Query(value="select * from pokemon where evolution->>'$.next' != 'null' order by pokedex_id" , nativeQuery = true)
    List<Pokemon> getPokemonBase();
    @Query(value="select * from pokemon where evolution->>'$.next' != 'null' LIKE %:search%" , nativeQuery = true)
    List<Pokemon> getPokemonBaseBySearch(@Param("search") String search);
    @Query(value="SELECT * FROM `pokemon` where evolution->>'$.pre' != 'null' and json_length(evolution->>'$.next') = 1 and evolution->>'$.next' != 'null' order by pokedex_id", nativeQuery = true)
    List<Pokemon> getPokemonStade1();
    @Query(value="SELECT * FROM `pokemon` where evolution->>'$.pre' != 'null' and json_length(evolution->>'$.next') = 1 and evolution->>'$.next' != 'null' order by pokedex_id LIKE %:search%", nativeQuery = true)
    List<Pokemon> getPokemonStade1BySearch(@Param("search") String search);
    @Query(value = "SELECT * FROM pokemon WHERE evolution->>'$.pre' = 'null' and json_length(evolution->>'$.next') = 1" , nativeQuery = true)
    List<Pokemon> getPokemonsEvo1();
    @Query(value = "SELECT * FROM `pokemon` where evolution->>'$.pre' != 'null' and json_length(evolution->>'$.pre') = 2 order by pokedex_id" , nativeQuery = true)
    List<Pokemon> getPokemonsStade2();
    @Query(value = "SELECT * FROM `pokemon` where evolution->>'$.pre' != 'null' and json_length(evolution->>'$.pre') = 2 order by pokedex_id LIKE %:search%" , nativeQuery = true)
    List<Pokemon> getPokemonsStade2BySearch(@Param("search") String search);
    @Query(value = "SELECT * FROM `pokemon` where evolution->>'$.pre' = 'null' and evolution->>'$.next' = 'null' and json_length(sexe) = 2 ORDER BY pokedex_id ASC" , nativeQuery = true)
    List<Pokemon> getPokemonsByNotEvolution();
    @Query(value="SELECT * FROM `pokemon` WHERE json_length(sexe) = 1 AND stats->>'$.hp' > 70 and evolution->>'$.pre' = 'null' and evolution->>'$.next' = 'null' and name->>'$.fr' != 'Hexagel' and name->>'$.fr' != 'Pokémon Fossile' ORDER BY `pokemon`.`pokedex_id`" , nativeQuery = true)
    List<Pokemon> getPokemonsByLengend();
    @Query( value = "SELECT * FROM pokemon ORDER BY pokedex_id LIMIT :limit OFFSET :offset" , nativeQuery = true)
    List<Pokemon> getPaginated( @Param("limit") Long limit , @Param("offset") Long offset);


}

package com.pokemonapi.restpokemon.Controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokemonapi.restpokemon.Entity.Pokemon;
import com.pokemonapi.restpokemon.Repository.PokemonRepository;
import com.pokemonapi.restpokemon.Service.PokemonService;
import com.pokemonapi.restpokemon.Service.PokemonServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/rest/pokemon")
@CrossOrigin
@RequiredArgsConstructor
public class PokemonRestController {

    private final PokemonService pokemonService;
    @RequestMapping(method = RequestMethod.POST , name = "app_pokemon_create" , value = "/create")
    public ResponseEntity<Object> create(@Valid  @RequestBody Pokemon pokemon , BindingResult result){
        HashMap<String , Object> res = new HashMap<>();
        if(result.hasErrors()){
            res.put("message" , "Une erreur est survenu...");
            res.put("error" , result.getAllErrors());
            return new ResponseEntity<>(res , HttpStatus.BAD_REQUEST);
        }
        res.put("message" , "Vous avez crée avec succès la génération");
        res.put("data" , this.pokemonService.createPokemon(pokemon));
        return new ResponseEntity<>(res , HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET , name = "app_pokemon_all" , value = "/all")
    public ResponseEntity<Object> all(){
        HashMap<String , Object> res = new HashMap<>();
        if(this.pokemonService.getAllPokemon() == null){
            res.put("message" , "Une erreur est survenu...");
            res.put("error" , "Vous n'avez pas récupérée avec succès la liste de pokémon.");
            return new ResponseEntity<>(res , HttpStatus.NOT_FOUND);
        }
        res.put("message" , "Vous avez récupérer avec succès avec la liste de pokémon.");
        res.put("data" , this.pokemonService.getAllPokemon());
        return new ResponseEntity<>(res , HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET , name = "app_pokemon_pokedex" , value="/pokedex/{id}")
    public ResponseEntity<Object> pokedex(@PathVariable  Long id){
        HashMap<String , Object> res = new HashMap<>();
        if(this.pokemonService.getPokemonsByPokedexId(id) == null){
            res.put("message" , "Une erreur est survenu...");
            res.put("error" , "Vous n'avez pas récupérée le pokémon avec succès.");
            return new ResponseEntity<>(res , HttpStatus.NOT_FOUND);
        }
        res.put("message" , "Vous avez récupérer avec succès avec un pokémon.");
        res.put("data" , this.pokemonService.getPokemonsByPokedexId(id));
        return new ResponseEntity<>(res , HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET , name = "app_pokemon_search" , value = "/search/{search}")
    public ResponseEntity<Object> search(@PathVariable("search") String search){
        HashMap<String , Object> res = new HashMap<>();
        if(this.pokemonService.getSearchPokemon(search) == null){
            res.put("message" , "Une erreur est survenu...");
            res.put("error" , "Vous n'avez pas trouvé de pokemon.");
            return new ResponseEntity<>(res , HttpStatus.NOT_FOUND);
        }
        res.put("message" , "Vous avez trouvé avec succès le pokémon");
        res.put("data" , this.pokemonService.getSearchPokemon(search));
        return new ResponseEntity<>(res , HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET , name = "app_pokemon_types" , value = "/type/{type}")
    public ResponseEntity<Object> types(@PathVariable("type") String type){
        HashMap<String , Object> res = new HashMap<>();
        if(this.pokemonService.getTypePokemon(type) == null){
            res.put("message" , "Une erreur est survenu...");
            res.put("error" , "Vous n'avez pas trouvé de pokemon de type " + type);
            return new ResponseEntity<>(res , HttpStatus.NOT_FOUND);
        }
        res.put("message" , "Vous avez trouvé avec succès les pokémon de type " + type);
        res.put("data" , this.pokemonService.getTypePokemon(type));
        return new ResponseEntity<>(res , HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET , name = "app_pokemon_category" , value = "/category/{category}")
    public ResponseEntity<Object> category(@PathVariable("category") String category){
        HashMap<String , Object> res = new HashMap<>();
        if(this.pokemonService.getPokemonsByCategory(category) == null){
            res.put("message" , "Une erreur est survenu...");
            res.put("error" , "Vous n'avez pas trouvé de pokemon de category " + category);
            return new ResponseEntity<>(res , HttpStatus.NOT_FOUND);
        }
        res.put("message" , "Vous avez trouvé avec succès les pokémon de category " + category);
        res.put("data" , this.pokemonService.getPokemonsByCategory(category));
        return new ResponseEntity<>(res , HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET , name = "app_pokemon_category" , value = "/evolution")
    public ResponseEntity<Object> base(@RequestParam("evo") String evo){
        HashMap<String , Object> res = new HashMap<>();
        if(evo.equals("base")){
            if(this.pokemonService.getPokemonBase() == null){
                res.put("message" , "Une erreur est survenu...");
                res.put("error" , "Vous n'avez pas trouvé de pokemon de base ");
                return new ResponseEntity<>(res , HttpStatus.NO_CONTENT);
            }
            res.put("message" , "Vous avez trouvé avec succès les pokémon de base " );
            res.put("data" , this.pokemonService.getPokemonBase());
        }
        if(evo.equals("stade1")){
            if(this.pokemonService.findByStade1() == null){
                res.put("message" , "Une erreur est survenu...");
                res.put("error" , "Vous n'avez pas trouvé de pokemon de stade 1");
                return new ResponseEntity<>(res , HttpStatus.NO_CONTENT);
            }
            res.put("message" , "Vous avez trouvé avec succès les pokémon de stade 1" );
            res.put("data" , this.pokemonService.findByStade1());
        }
        if(evo.equals("stade2")){
            if(this.pokemonService.findByStade2() == null){
                res.put("message" , "Une erreur est survenu...");
                res.put("error" , "Vous n'avez pas trouvé de pokemon de stade 2");
                return new ResponseEntity<>(res , HttpStatus.NO_CONTENT);
            }
            res.put("message" , "Vous avez trouvé avec succès les pokémon de stade 1" );
            res.put("data" , this.pokemonService.findByStade2());
        }
        if(evo.equals("not-evolution")){
            if(this.pokemonService.getPokemonsByNotEvolution() == null){
                res.put("message" , "Une erreur est survenu...");
                res.put("error" , "Vous n'avez pas trouvé de pokémon qui n'ont pas d'évolution");
                return new ResponseEntity<>(res , HttpStatus.NO_CONTENT);
            }
            res.put("message" , "Vous avez trouvé avec succès les pokémon non évoluée !");
            res.put("data" , this.pokemonService.getPokemonsByNotEvolution());
        }
        if(evo.equals("legend")){
            if(this.pokemonService.getPokemonsByLegend() == null){
                res.put("message" , "Une erreur est survenu...");
                res.put("error" , "Vous n'avez pas trouvé de pokémon qui n'ont pas d'évolution");
                return new ResponseEntity<>(res , HttpStatus.NO_CONTENT);
            }
            res.put("message" , "Vous avez trouvé avec succès les pokémon légendaires!");
            res.put("data" , this.pokemonService.getPokemonsByLegend());
        }
        return new ResponseEntity<>(res , HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET , name = "app_pokemon_id" , value = "/identify/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id){
        HashMap<String , Object> res = new HashMap<>();
        if(this.pokemonService.getPokemonById(id) == null){
            res.put("message" , "Une erreur est survenue");
            res.put("error" , "l'identifiant ne correspond pas à un pokémon.");
            return new ResponseEntity<>(res , HttpStatus.NOT_FOUND);
        }
        res.put("message" , "Vous avez récupérée un pokémon par l'id");
        res.put("data" , this.pokemonService.getPokemonById(id));
        return new ResponseEntity<>(res , HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET, name = "app_pokemon_paginated" , value = "/paginated")
    public ResponseEntity<Object> paginated(@RequestParam(name = "page", defaultValue = "1") Long page,
                                            @RequestParam(name = "limit", defaultValue = "10") Long limit){
        Long offset = ((page - 1 ) * limit);
        HashMap<String , Object> res = new HashMap<>();
        if(this.pokemonService.getPaginated(limit , offset) == null){
            res.put("message" , "Une erreur est survenue");
            res.put("error" , "la pagination n'a pas été récupérer ,page > nombre total de pokémon");
            return new ResponseEntity<>(res , HttpStatus.NOT_FOUND);
        }
        res.put("message" , "Vous avez récupérée un pokémon par l'id");
        res.put("data" , this.pokemonService.getPaginated(limit , offset));
        return new ResponseEntity<>(res , HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET, name = "app_pokemon_name" , value= "/name")
    public ResponseEntity<Object> name(@RequestParam("name") String name){
        HashMap<String, Object> res = new HashMap<>();
        if(this.pokemonService.findByName(name) == null){
            res.put("message" , "Une erreur est survenu...");
            res.put("error" , "le nom n'existe pas et la liste n'a pas récupérée.");
            return new ResponseEntity<>(res , HttpStatus.NOT_FOUND);
        }
        res.put("message" , "Vous avez récupérée un pokémon avec succès.");
        res.put("pokemon" , this.pokemonService.findByName(name));
        return new ResponseEntity<>(res , HttpStatus.OK);
    }



}

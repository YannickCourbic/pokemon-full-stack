package com.pokemonapi.restpokemon.Controller;

import com.pokemonapi.restpokemon.Entity.Generation;
import com.pokemonapi.restpokemon.Service.GenerationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/rest/pokemon/gen")
@CrossOrigin
public class GenerationRestController {
    @Autowired
    private GenerationService generationService;
    @RequestMapping(method = RequestMethod.POST , name = "app_pokemon_create" , value = "/create" )
    public ResponseEntity<Object> create(@Valid  @RequestBody Generation generation , BindingResult result){
        HashMap<String , Object> res = new HashMap<>();
        if(result.hasErrors()){
            System.out.println("Validation errors: " + result.getAllErrors());
            res.put("message" , "Une erreur est survenu...");
            res.put("error" , result.getAllErrors());
            return new ResponseEntity<>(res , HttpStatus.BAD_REQUEST);
        }
        if(this.generationService.existsByRegion(generation.getRegion())){
            res.put("message" , "Une erreur est survenu...");
            res.put("error" , "la région est déjà crée");
            return new ResponseEntity<>(res , HttpStatus.BAD_REQUEST);
        }

        res.put("message" , "Vous avez crée avec succès la génération");
        res.put("data" , this.generationService.createGeneration(generation));
        return new ResponseEntity<>(res , HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT , name = "app_pokemon_create" , value = "/update" )
    public ResponseEntity<Object> update(@Valid  @RequestBody Generation generation , BindingResult result){
        HashMap<String , Object> res = new HashMap<>();
        if(result.hasErrors()){
            System.out.println("Validation errors: " + result.getAllErrors());
            res.put("message" , "Une erreur est survenu...");
            res.put("error" , result.getAllErrors());
            return new ResponseEntity<>(res , HttpStatus.BAD_REQUEST);
        }
        res.put("message" , "Vous avez modifiée avec succès la génération");
        res.put("data" , this.generationService.createGeneration(generation));
        return new ResponseEntity<>(res , HttpStatus.CREATED);
    }
    @RequestMapping(method = RequestMethod.GET , name = "app_pokemon_id" , value = "/{id}")
    public ResponseEntity<Object> find(@PathVariable Long id){
        HashMap<String , Object> res = new HashMap<>();
        if(this.generationService.getGenerationById(id) == null){
            res.put("message" , "Une erreur est survenu...");
            res.put("error" , "L'identifiant ne correspond pas à une génération.");
            return new ResponseEntity<>(res , HttpStatus.NOT_FOUND);
        }
        res.put("message" , "Vous avez récupérée la génération avec succès.");
        res.put("generation" , this.generationService.getGenerationById(id));
        return new ResponseEntity<>(res , HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET , name = "app_pokemon_all" , value = "/all")
    public ResponseEntity<Object> all(){
        HashMap<String , Object> res = new HashMap<>();
        if(this.generationService.getAllGeneration() == null){
            res.put("message" , "Une erreur est survenue...");
            res.put("error" , "Vous n'avez pas récupérée la liste de génération");
            return new ResponseEntity<>(res , HttpStatus.NOT_FOUND);
        }
        res.put("message" , "Vous avez récupérée la génération avec succès.");
        res.put("generations" , this.generationService.getAllGeneration());
        return new ResponseEntity<>(res , HttpStatus.OK);
    }


}

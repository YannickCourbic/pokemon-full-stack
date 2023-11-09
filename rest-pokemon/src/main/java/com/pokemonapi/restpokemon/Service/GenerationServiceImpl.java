package com.pokemonapi.restpokemon.Service;

import com.pokemonapi.restpokemon.Entity.Generation;
import com.pokemonapi.restpokemon.Repository.GenerationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class GenerationServiceImpl implements GenerationService{

    @Autowired
    private GenerationRepository generationRepository;
    @Override
    public Object createGeneration(Generation g) {
        Map<String , Object> res = new HashMap<>();
        try{
            res.put("message" , "Vous avez crée avec succès une genération ");
            res.put("generation" , this.generationRepository.save(g));
            return res;
        }catch (Exception e){
            e.printStackTrace();
            res.put("message" , "Une erreur est survenu...");
            return res;
        }
    }

    @Override
    public Object updatedGeneration(Generation g) {
        Map<String , Object> res = new HashMap<>();
        try{
            res.put("message" , "Vous avez modifié avec succès une genération ");
            res.put("generation" , this.generationRepository.save(g));
            return res;
        }catch (Exception e){
            e.printStackTrace();
            res.put("message" , "Une erreur est survenu...");
            return res;
        }
    }

    @Override
    public Generation getGeneration(Generation g) {
        Optional<Generation> optionalGeneration = this.generationRepository.findById(g.getId());
        return optionalGeneration.orElse(null);
    }

    @Override
    public Generation getGenerationById(Long id) {
        Optional<Generation> optionalGeneration = this.generationRepository.findById(id);
        return optionalGeneration.orElse(null);
    }

    @Override
    public List<Generation> getAllGeneration() {
        Optional<List<Generation>> optionalGenerations = Optional.of(this.generationRepository.findAll());
        return optionalGenerations.orElse(null);
    }
}

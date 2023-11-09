package com.pokemonapi.restpokemon.Service;

import com.pokemonapi.restpokemon.Entity.Generation;

import java.util.List;

public interface GenerationService {
    Object createGeneration(Generation g);
    Object updatedGeneration(Generation g);
    Generation getGeneration(Generation g);
    Generation getGenerationById(Long id);
    List<Generation> getAllGeneration();
}

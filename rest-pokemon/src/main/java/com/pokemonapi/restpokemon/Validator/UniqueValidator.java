package com.pokemonapi.restpokemon.Validator;

import com.pokemonapi.restpokemon.Entity.Generation;
import com.pokemonapi.restpokemon.Service.GenerationService;
import com.pokemonapi.restpokemon.Service.GenerationServiceImpl;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

public class UniqueValidator implements ConstraintValidator<UniqueValidation,String > {
    private String entityClass;
    @Autowired
    private GenerationServiceImpl generationService;
    @Override
    public void initialize(UniqueValidation constraintAnnotation) {
        this.entityClass = constraintAnnotation.entityClass();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

            if(this.generationService.existsByRegion(value)){
                return false;
            }
        return true;
    }


}

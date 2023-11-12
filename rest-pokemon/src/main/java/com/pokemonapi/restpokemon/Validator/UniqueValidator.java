package com.pokemonapi.restpokemon.Validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueGenerationValidator implements ConstraintValidator<UniqueGenerationValidation,String > {
    @Override
    public void initialize(UniqueGenerationValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}

package com.pokemonapi.restpokemon.Validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueValidator.class) // MyCustomValidator est la classe de validation personnalisée que vous créerez
@Documented
public @interface UniqueValidation {
    String message() default "La region existe déjà";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String entityClass();
}

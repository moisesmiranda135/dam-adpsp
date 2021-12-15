package com.salesianos.triana.dam.E01PracticaGuiada.validation.anotations;

import com.salesianos.triana.dam.E01PracticaGuiada.validation.validations.LocalitationMatchValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LocalitationMatchValidation.class)
@Documented
public @interface LocalitationMatch {

    String message() default "No puede existir dos estaciones con la misma localizacion";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}

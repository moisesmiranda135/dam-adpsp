package com.salesianos.triana.dam.E01PracticaGuiada.validation.anotations;

import com.salesianos.triana.dam.E01PracticaGuiada.validation.validations.LocalitationMatchValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = LocalitationMatchValidation.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LocalitationMatch {

    String message() default "No puede existir dos estaciones con la misma localizacion";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};

    String localitationField();
    String verifyLocalitationField();
}

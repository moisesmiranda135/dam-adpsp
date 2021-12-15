package com.salesianos.triana.dam.E01PracticaGuiada.validation.anotations;

import com.salesianos.triana.dam.E01PracticaGuiada.validation.validations.FetchMatchValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = FetchMatchValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FetchMatch {

    String message() default "La fecha introducida debe ser menor o igual a la fecha de registro del objeto.\n";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};

    String fetchField();
    String verifyfetchField();
}

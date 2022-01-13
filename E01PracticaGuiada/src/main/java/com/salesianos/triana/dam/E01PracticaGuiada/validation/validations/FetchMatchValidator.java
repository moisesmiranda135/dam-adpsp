package com.salesianos.triana.dam.E01PracticaGuiada.validation.validations;

import com.salesianos.triana.dam.E01PracticaGuiada.validation.anotations.FetchMatch;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class FetchMatchValidator implements ConstraintValidator<FetchMatch, Object> {

    private String fetchField;
    private String verifyfetchField;


    @Override
    public void initialize(FetchMatch constraintAnnotation) {
        fetchField = constraintAnnotation.fetchField();
        verifyfetchField = constraintAnnotation.verifyfetchField();
    }


    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        LocalDate fetch = (LocalDate) PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(fetchField);
        LocalDate verifyfetch = (LocalDate) PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(verifyfetchField);

        return fetch.isBefore(verifyfetch) || fetch.equals(verifyfetch);
    }
}

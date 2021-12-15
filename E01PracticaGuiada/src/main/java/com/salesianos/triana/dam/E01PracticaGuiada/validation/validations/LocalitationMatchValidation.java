package com.salesianos.triana.dam.E01PracticaGuiada.validation.validations;

import com.salesianos.triana.dam.E01PracticaGuiada.validation.anotations.LocalitationMatch;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LocalitationMatchValidation implements ConstraintValidator<LocalitationMatch, Object> {

    private String localitationField;
    private String verifyLocalitationFiled;

    @Override
    public void initialize(LocalitationMatch contraintAnnotation){
        localitationField = contraintAnnotation.localitationField();
        verifyLocalitationFiled = contraintAnnotation.verifyLocalitationField();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        String localitation = (String) PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(localitationField);
        String verifyLocalitation = (String) PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(verifyLocalitationFiled);

        return StringUtils.hasText(localitation) && localitation.contentEquals(verifyLocalitation);


    }
}

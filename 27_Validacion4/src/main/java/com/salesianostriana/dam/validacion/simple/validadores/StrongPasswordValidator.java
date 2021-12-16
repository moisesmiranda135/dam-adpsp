package com.salesianostriana.dam.validacion.simple.validadores;


import com.salesianostriana.dam.validacion.simple.anotaciones.PasswordsMatch;
import com.salesianostriana.dam.validacion.simple.anotaciones.StrongPassword;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class StrongPasswordValidator implements ConstraintValidator<StrongPassword, Object> {

    private String passwordField;
    private String minField;
    private String maxField;
    private String hasUpperField;
    private String hasLowerField;
    private String hasNumberField;
    private String hasAlphaField;
    private String hasOthersField;


    @Override
    public void initialize(StrongPassword constraintAnnotation) {
        passwordField = constraintAnnotation.passwordField();
        minField = constraintAnnotation.minField();
        maxField = constraintAnnotation.passwordField();
        hasUpperField = constraintAnnotation.maxField();
        hasLowerField = constraintAnnotation.hasLowerField();
        hasNumberField = constraintAnnotation.hasNumberField();
        hasAlphaField = constraintAnnotation.hasAlphaField();
        hasOthersField = constraintAnnotation.hasOthersField();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        int min = 1;
        int max = 5;
        boolean hasUpper = true;
        boolean hasLower = true;
        boolean hasNumber = true;
        boolean hasAlpha = true;
        boolean hasOthers = true;

        String password = (String) PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(passwordField);
        Pattern HasUpperPattern = Pattern.compile("[A-Z]");
        Pattern HasLowerPattern = Pattern.compile("[a-z]");
        Pattern HasNumberPattern = Pattern.compile("[1234567890]");
        Pattern HasAlphaPattern = Pattern.compile("[abcdfghijklmnñopqrstuwvxyzABCDEFGHIJKLMNÑOPQRSTUWZYZ]");
        Pattern HasOthersPattern = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);


        if ((password.length() >= min && password.length() <= max)
                && (hasLower == true && HasUpperPattern.matcher(password).find() || (hasLower == false))
                && (hasUpper == true && HasLowerPattern.matcher(password).find() || (hasUpper == false))
                && (hasNumber == true && HasNumberPattern.matcher(password).find() || (hasNumber == false))
                && (hasAlpha == true && HasAlphaPattern.matcher(password).find() || (hasAlpha == false))
                && (hasOthers == true && HasOthersPattern.matcher(password).find() || (hasOthers == false))
        ){
            return true;
        } else {
            return password == null;
        }
    }

}


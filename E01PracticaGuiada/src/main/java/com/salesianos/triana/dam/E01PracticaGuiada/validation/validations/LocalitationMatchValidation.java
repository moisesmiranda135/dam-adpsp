package com.salesianos.triana.dam.E01PracticaGuiada.validation.validations;

import com.salesianos.triana.dam.E01PracticaGuiada.repositories.EstacionServicioRepository;
import com.salesianos.triana.dam.E01PracticaGuiada.validation.anotations.LocalitationMatch;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LocalitationMatchValidation implements ConstraintValidator<LocalitationMatch, String> {


    @Autowired
    private EstacionServicioRepository estacionServicioRepository;

    @Override
    public void initialize(LocalitationMatch constraintAnnotation) { }

    @Override
    public boolean isValid(String nombre, ConstraintValidatorContext context) {
        return StringUtils.hasText(nombre) && !estacionServicioRepository.existsByUbicacion(nombre);
    }
}

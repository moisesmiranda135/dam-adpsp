package com.salesianos.triana.dam.E01PracticaGuiada.errors.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiValidationSubError extends ApiSubError {

    private String objeto, campo, mensaje;
    private Object valorRechazado;


}

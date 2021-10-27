package com.salesianos.triana.Dam.Ejercicio08.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class ClienteParticular extends Cliente implements Serializable {

    private LocalDate fechaPart;


    public ClienteParticular (String email, String nombre, String apellidos, LocalDate fechaPart) {
        super(email, nombre, apellidos);
        this.fechaPart = fechaPart;
    }
}

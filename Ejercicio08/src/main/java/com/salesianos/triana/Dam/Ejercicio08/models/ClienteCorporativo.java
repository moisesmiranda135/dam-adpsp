package com.salesianos.triana.Dam.Ejercicio08.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class ClienteCorporativo  extends Cliente implements Serializable {

    private LocalDate fechaCorp;

    @ManyToOne
    private Empleado empleado;

    public ClienteCorporativo (String email, String nombre, String apellidos, LocalDate fechaCorp) {
        super(email, nombre, apellidos);
        this.fechaCorp = fechaCorp;
    }


}

package com.salesianos.triana.Dam.Ejercicio08.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
/*
En este caso si he elegido una asiciación bidireccional, ya que pienso que si es util poder traeme
todos los Clientes Corporativos que sean representados por un Empeado
 */
public class Empleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nombre;

    private String departamento;

    private double sueldo;

    @OneToMany (mappedBy="empleado")
    @Builder.Default
    private List<ClienteCorporativo> listaCorporativos = new ArrayList<>();


    // HELPERS

    public void addClienteCorporativo(ClienteCorporativo c) {
        this.listaCorporativos.add(c);
        c.setEmpleado(this);
    }

    public void removeAlumno(ClienteCorporativo c) {
        this.listaCorporativos.remove(c);
        c.setEmpleado(null);
    }

}

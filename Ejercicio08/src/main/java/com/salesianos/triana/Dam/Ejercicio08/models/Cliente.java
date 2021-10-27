package com.salesianos.triana.Dam.Ejercicio08.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
/*
He utilizado la herencia JOINED porque creo que es mas conveniente tener una tabla
para cada entidad, también decido que la clase será abstracta ya que pienso que no es util tener un cliente
generalizado, por lo que cuando cree un cliente sera o un ClienteCorporativo o un Cliente Particular.
 */
public abstract class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String email;

    private String nombre;

    private String apellidos;


    public Cliente(String email, String nombre, String apellidos) {
        this.email = email;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
}

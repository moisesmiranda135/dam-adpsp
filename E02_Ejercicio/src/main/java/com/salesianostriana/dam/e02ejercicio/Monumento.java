package com.salesianostriana.dam.e02ejercicio;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity //Para convertir la clase en una entidad (una clase paraa guardar información)
@Data //Genera getters setters has code y to string
@NoArgsConstructor //Genera construtor sin parametros
public class Monumento {

    @Id // Sirve especifica la clave principal de una entidad.
    @GeneratedValue //Sirve para generar valores, en este caso para la id de la entidad
    private Long id;

    private String codigoPais;

    private String pais;

    private String ciudad;

    private String loc;

    private String nombre;

    @Lob // sirve para indicar que se utilice el objeto mas grande compatible en la BBDD.
    //@Column(length = 1000) para dar un tamaño especifico
    //@Column(columnDefinition = "TEXT") para definir un obejto compatible en la BBDD
    private String descripcion;

    private String urlImagen;



}

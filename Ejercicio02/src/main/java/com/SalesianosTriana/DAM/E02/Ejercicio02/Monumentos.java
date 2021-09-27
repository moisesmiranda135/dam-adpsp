package com.SalesianosTriana.DAM.E02.Ejercicio02;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Monumentos {

    @Id
    @GeneratedValue
    private Long id;

    private String codigoPais;

    private String nomPais;

    private String nomCiudad;

    private String latLong;

    private String nomMonumento;

    // @Lob PARA CONVERTIR EL STRING EN EL ALMACENAMIENTO MAS GRANDE QUE SE PUEDA (GUARDAR MÁS INFORMACIÓ)
    private String descripcion;

    private String url;

    public Monumentos(String codigoPais, String nomPais, String nomCiudad, String latLong, String nomMonumento, String descripcion, String url) {
        this.codigoPais = codigoPais;
        this.nomPais = nomPais;
        this.nomCiudad = nomCiudad;
        this.latLong = latLong;
        this.nomMonumento = nomMonumento;
        this.descripcion = descripcion;
        this.url = url;
    }
}

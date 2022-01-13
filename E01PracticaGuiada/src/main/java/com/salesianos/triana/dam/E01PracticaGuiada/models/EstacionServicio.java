package com.salesianos.triana.dam.E01PracticaGuiada.models;

import com.salesianos.triana.dam.E01PracticaGuiada.validation.anotations.FetchMatch;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EntityListeners(AuditingEntityListener.class)
public class EstacionServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String marca;

    private String ubicacion;

    private boolean tieneAutolavado;

    private double precioGasoilNormal;

    private double precioGasolina95Octanos;

    private double precioGasoilEspecial;

    private double precioGasolina98;

    @Lob
    private String servicios;


    private LocalDate fechaApertura;

    @CreatedDate
    private LocalDate fechaRegistro;

    public EstacionServicio(String nombre, String marca, String ubicacion, boolean tieneAutolavado, double precioGasoilNormal, double precioGasolina95Octanos, double precioGasoilEspecial, double precioGasolina98, String servicios, LocalDate fechaApertura) {
        this.nombre = nombre;
        this.marca = marca;
        this.ubicacion = ubicacion;
        this.tieneAutolavado = tieneAutolavado;
        this.precioGasoilNormal = precioGasoilNormal;
        this.precioGasolina95Octanos = precioGasolina95Octanos;
        this.precioGasoilEspecial = precioGasoilEspecial;
        this.precioGasolina98 = precioGasolina98;
        this.servicios = servicios;
        this.fechaApertura = fechaApertura;
    }
}

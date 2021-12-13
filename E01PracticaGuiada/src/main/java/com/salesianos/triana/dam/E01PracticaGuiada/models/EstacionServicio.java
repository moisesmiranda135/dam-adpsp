package com.salesianos.triana.dam.E01PracticaGuiada.models;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    @NotBlank(message = "{estacionServicio.nombre.blank}")
    @NotNull(message = "{estacionServicio.nombre.null}")
    private String nombre;

    @NotBlank(message = "{estacionServicio.marca.blank}")
    private String marca;

    @NotNull(message = "{estacionServicio.ubicacion.null}")
    private String ubicacion;

    private boolean tieneAutolavado;

    @NotNull(message = "estacionServicio.precioGasoilNormal.null")
    @Min(value = 0, message = "estacionServicio.precio.min")
    private double precioGasoilNormal;

    @NotNull(message = "estacionServicio.precioGasolina95Octanos.null")
    @Min(value = 0, message = "estacionServicio.precio.min")
    private double precioGasolina95Octanos;

    @Min(value = 0, message = "estacionServicio.precio.min")
    private double precioGasoilEspecial;

    @Min(value = 0, message = "estacionServicio.precio.min")
    private double precioGasolina98;

    @Lob
    private String servicios;

    @CreatedDate
    private LocalDateTime fechaApertura;
}

package com.salesianos.triana.dam.E01PracticaGuiada.dto;

import com.salesianos.triana.dam.E01PracticaGuiada.validation.anotations.FetchMatch;
import com.salesianos.triana.dam.E01PracticaGuiada.validation.anotations.LocalitationMatch;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Lob;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@FetchMatch(fetchField = "fechaApertura", verifyfetchField = "fechaRegistro", message = "{estacionServicio.fecha.notmatch}")
public class CreateEstacionServicioDTO {


    @NotBlank(message = "{estacionServicio.nombre.blank}")
    @NotNull(message = "{estacionServicio.nombre.null}")
    private String nombre;

    @NotBlank(message = "{estacionServicio.marca.blank}")
    private String marca;

    @NotNull(message = "{estacionServicio.ubicacion.null}")
    @Pattern(regexp ="^[-+]?([1-8]?\\d(\\.\\d+)?|90(\\.0+)?),\\s*[-+]?(180(\\.0+)?|((1[0-7]\\d)|([1-9]?\\d))(\\.\\d+)?)$"
            ,message = "{estacionServicio.ubicacion.pattern}" )
    @LocalitationMatch(message = "{estacionServicio.ubicacion.localitationMatch}")
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

    private String servicios;

    private LocalDate fechaApertura;

    private LocalDate fechaRegistro;
}

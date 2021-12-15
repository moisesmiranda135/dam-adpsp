package com.salesianos.triana.dam.E01PracticaGuiada.dto;

import com.salesianos.triana.dam.E01PracticaGuiada.models.EstacionServicio;
import org.springframework.stereotype.Component;

@Component
public class EstacionServicioConverter {

    public EstacionServicio creted(CreateEstacionServicioDTO estacionServicio){
        return new EstacionServicio(
                estacionServicio.getNombre(),
                estacionServicio.getMarca(),
                estacionServicio.getUbicacion(),
                estacionServicio.isTieneAutolavado(),
                estacionServicio.getPrecioGasolina95Octanos(),
                estacionServicio.getPrecioGasoilEspecial(),
                estacionServicio.getPrecioGasolina98(),
                estacionServicio.getPrecioGasoilNormal(),
                estacionServicio.getServicios(),
                estacionServicio.getFechaApertura()
        );
    }

}

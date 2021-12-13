package com.salesianos.triana.dam.E01PracticaGuiada.services;

import com.salesianos.triana.dam.E01PracticaGuiada.errors.exceptions.ListEntityNotFoundException;
import com.salesianos.triana.dam.E01PracticaGuiada.errors.exceptions.SingleEntityNotFoundException;
import com.salesianos.triana.dam.E01PracticaGuiada.models.EstacionServicio;
import com.salesianos.triana.dam.E01PracticaGuiada.repositories.EstacionServicioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstacionServicioService {

    private final EstacionServicioRepository estacionServicioRepository;

    public List<EstacionServicio> findAll() {
        List<EstacionServicio> result = estacionServicioRepository.findAll();

        if (result.isEmpty()) {
            throw new ListEntityNotFoundException(EstacionServicio.class);
        } else {
            return result;
        }
    }


    public EstacionServicio findById(Long id) {
        return estacionServicioRepository.findById(id)
                .orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), EstacionServicio.class));
    }


    public EstacionServicio save(EstacionServicio estacionServicio) {
        return estacionServicioRepository.save(estacionServicio);
    }

    public EstacionServicio edit(EstacionServicio editar,Long id) {

        return estacionServicioRepository.findById(id).map(e -> {

            e.setNombre(editar.getNombre());
            e.setServicios(editar.getServicios());
            e.setFechaApertura(editar.getFechaApertura());
            e.setMarca(editar.getMarca());
            e.setUbicacion(editar.getUbicacion());
            e.setTieneAutolavado(editar.isTieneAutolavado());
            e.setPrecioGasoilNormal(editar.getPrecioGasoilNormal());
            e.setPrecioGasolina95Octanos(editar.getPrecioGasolina95Octanos());
            e.setPrecioGasolina98(editar.getPrecioGasolina98());
            e.setPrecioGasoilEspecial(editar.getPrecioGasoilEspecial());
            return estacionServicioRepository.save(e);
        }).orElseThrow(() -> new SingleEntityNotFoundException(id.toString(),EstacionServicio.class));
    }


    public void deleteById(Long id) {

        Optional<EstacionServicio> estacionServicio = estacionServicioRepository.findById(id);
        if(estacionServicio.isEmpty()){
            throw new SingleEntityNotFoundException(id.toString(),EstacionServicio.class);
        }else{
            estacionServicioRepository.deleteById(id);
        }
    }

}

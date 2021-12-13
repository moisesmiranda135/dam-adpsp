package com.salesianos.triana.dam.E01PracticaGuiada.services;

import com.salesianos.triana.dam.E01PracticaGuiada.errors.exceptions.ListEntityNotFoundException;
import com.salesianos.triana.dam.E01PracticaGuiada.errors.exceptions.SingleEntityNotFoundException;
import com.salesianos.triana.dam.E01PracticaGuiada.models.EstacionServicio;
import com.salesianos.triana.dam.E01PracticaGuiada.repositories.EstacionServicioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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


    public EstacionServicio save(EstacionServicio producto) {
        return estacionServicioRepository.save(producto);
    }
}

package com.salesianos.triana.dam.E01PracticaGuiada.services;

import com.salesianos.triana.dam.E01PracticaGuiada.repositories.EstacionServicioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EstacionServicioService {

    private final EstacionServicioRepository estacionServicioRepository;
}

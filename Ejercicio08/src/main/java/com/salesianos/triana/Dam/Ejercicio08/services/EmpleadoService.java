package com.salesianos.triana.Dam.Ejercicio08.services;

import com.salesianos.triana.Dam.Ejercicio08.models.Empleado;
import com.salesianos.triana.Dam.Ejercicio08.repositories.EmpleadoRepository;
import com.salesianos.triana.Dam.Ejercicio08.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService
        extends BaseService<Empleado, Long, EmpleadoRepository> {
}

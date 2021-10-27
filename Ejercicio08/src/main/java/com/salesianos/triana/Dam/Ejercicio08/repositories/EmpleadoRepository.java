package com.salesianos.triana.Dam.Ejercicio08.repositories;

import com.salesianos.triana.Dam.Ejercicio08.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository
        extends JpaRepository<Empleado,Long> {
}

package com.salesianos.triana.Dam.Ejercicio08.repositories;

import com.salesianos.triana.Dam.Ejercicio08.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository
        extends JpaRepository<Cliente,Long> {
}

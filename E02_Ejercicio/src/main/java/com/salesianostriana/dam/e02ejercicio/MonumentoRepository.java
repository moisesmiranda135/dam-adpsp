package com.salesianostriana.dam.e02ejercicio;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MonumentoRepository //Proporciona algunos métodos relacionados con JPA (como buscar por id, guardar...
        extends JpaRepository<Monumento, Long> {
}

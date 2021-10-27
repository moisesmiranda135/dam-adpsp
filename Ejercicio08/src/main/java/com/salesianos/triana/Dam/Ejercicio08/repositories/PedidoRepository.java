package com.salesianos.triana.Dam.Ejercicio08.repositories;

import com.salesianos.triana.Dam.Ejercicio08.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository
        extends JpaRepository<Pedido,Long> {
}

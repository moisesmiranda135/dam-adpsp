package com.salesianos.triana.Dam.Ejercicio08.services;

import com.salesianos.triana.Dam.Ejercicio08.models.Pedido;
import com.salesianos.triana.Dam.Ejercicio08.repositories.PedidoRepository;
import com.salesianos.triana.Dam.Ejercicio08.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class PedidoService
        extends BaseService<Pedido, Long, PedidoRepository> {
}

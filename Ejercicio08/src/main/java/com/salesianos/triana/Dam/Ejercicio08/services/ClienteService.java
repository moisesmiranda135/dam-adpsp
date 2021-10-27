package com.salesianos.triana.Dam.Ejercicio08.services;

import com.salesianos.triana.Dam.Ejercicio08.models.Cliente;
import com.salesianos.triana.Dam.Ejercicio08.repositories.ClienteRepository;
import com.salesianos.triana.Dam.Ejercicio08.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ClienteService
        extends BaseService<Cliente, Long, ClienteRepository> {
}

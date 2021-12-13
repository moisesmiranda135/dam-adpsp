package com.salesianos.triana.dam.E01PracticaGuiada.controllers;

import com.salesianos.triana.dam.E01PracticaGuiada.models.EstacionServicio;
import com.salesianos.triana.dam.E01PracticaGuiada.services.EstacionServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/estacionServicio")
public class EstacionServicioController {

    private final EstacionServicioService estacionServicioService;

    @GetMapping("/")
    public List<EstacionServicio> todos() {
        return estacionServicioService.findAll();
    }

    @GetMapping("/{id}")
    public EstacionServicio uno(@PathVariable Long id) {
        return estacionServicioService.findById(id);
    }

    @PostMapping("/")
    public EstacionServicio crear(@Valid @RequestBody EstacionServicio estacionServicio) {
        return estacionServicioService.save(estacionServicio);
    }

    @DeleteMapping("/{id}")
    public void borrarEstacion(@PathVariable Long id) {
        estacionServicioService.deleteById(id);
    }

    @PutMapping("/{id}")
    public EstacionServicio editarProducto(@Valid @RequestBody EstacionServicio editar, @PathVariable Long id) {
        return estacionServicioService.edit(editar,id);
    }
}

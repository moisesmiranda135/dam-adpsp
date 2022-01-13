package com.salesianos.triana.dam.E01PracticaGuiada.controllers;

import com.salesianos.triana.dam.E01PracticaGuiada.dto.CreateEstacionServicioDTO;
import com.salesianos.triana.dam.E01PracticaGuiada.models.EstacionServicio;
import com.salesianos.triana.dam.E01PracticaGuiada.services.EstacionServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<EstacionServicio> crear(@Valid @RequestBody CreateEstacionServicioDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(estacionServicioService.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarEstacion(@PathVariable Long id) {
        estacionServicioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public EstacionServicio editarProducto(@Valid @RequestBody CreateEstacionServicioDTO editar, @PathVariable Long id) {
        return estacionServicioService.edit(editar,id);
    }
}

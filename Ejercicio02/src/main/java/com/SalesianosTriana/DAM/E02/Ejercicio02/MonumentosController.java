package com.SalesianosTriana.DAM.E02.Ejercicio02;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monumento")
@RequiredArgsConstructor
public class MonumentosController {

    private final MonumentosRepository repository;

    @GetMapping("/")
    public List<Monumentos> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Monumentos findOne(@PathVariable("id") Long id){
        return  repository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public ResponseEntity<Monumentos> create (@RequestBody Monumentos task) {
        // return repository.save(task);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(repository.save(task));
    }

    @PutMapping("/{id}")
    public Monumentos edit (@RequestBody Monumentos task, @PathVariable Long id) {

        Monumentos antigua = repository.findById(id).orElse(task);
        antigua.setCodigoPais(task.getCodigoPais());
        antigua.setNomPais(task.getNomMonumento());
        antigua.setNomMonumento(task.getNomMonumento());
        antigua.setLatLong(task.getLatLong());
        antigua.setNomCiudad(task.getNomCiudad());
        antigua.setDescripcion(task.getDescripcion());
        antigua.setUrl(task.getUrl());

        return repository.save(antigua);

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

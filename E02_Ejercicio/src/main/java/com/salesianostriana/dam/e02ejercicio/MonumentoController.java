package com.salesianostriana.dam.e02ejercicio;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //sirve para tratar a la clase como un controlador
/*
Cuando todos los métodos de una clase necesitan devolver una vista, esta clase se anota con @Controller.

Cuando todos los métodos de una clase necesitan devolver una cadena Json, la clase se anota con @RestController.
 */
@RequiredArgsConstructor
//(Preguntara a luismi) No generará ningún argumento para los campos, final, static, y no nulos inicializados
@RequestMapping("/monumento")
// Las anotaciones de los métodos utilizarán el valor de esta anotación como base o prefijo.
public class MonumentoController {

    private final MonumentoRepository repository; //final determina que un atributo no puede ser sobreescrito

    @GetMapping("/") //anotacion para mostar
    public ResponseEntity<List<Monumento>> findAll() {
    /*
    ResponseEntity maneja toda la respuesta HTTP incluyendo el cuerpo, cabecera y códigos de estado permitiéndonos
    total libertad de configurar la respuesta
     */
        return ResponseEntity
                .ok() // Un atajo para crear un ResponseEntitycon el cuerpo dado y el estado establecido en OK
                // (lo que sale en postman)
                .body(repository.findAll()); // Establece el cuerpo de la entidad de respuesta y lo devuelve.

    }

    @GetMapping("/{id}")
    public ResponseEntity<Monumento> findOne(@PathVariable Long id) {
        //PathVariable: para recibir parámetros. El valor del parámetro debe colocarse en la URL


        /*return ResponseEntity
                .ok()
                .body(repository.findById(id).orElse(null));
        */

        return ResponseEntity
                .of(repository.findById(id));

    }


    @PostMapping("/") //anotacion para crear
    public ResponseEntity<Monumento> create(@RequestBody Monumento nuevo) {
        //(Luismi) nos permite recuperar el cuerpo de la solicitud.

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(repository.save(nuevo));

    }

    @PutMapping("/{id}") //anotacion para editar
    public ResponseEntity<Monumento> edit(
            @RequestBody Monumento e,
            @PathVariable Long id) {

        return ResponseEntity.of(
            repository.findById(id).map(m -> {
               m.setCodigoPais(e.getCodigoPais());
               m.setPais(e.getPais());
               m.setCiudad(e.getCiudad());
               m.setDescripcion(e.getDescripcion());
               m.setLoc(e.getLoc());
               m.setNombre(e.getNombre());
               m.setUrlImagen(e.getUrlImagen());
               repository.save(m);
               return m;
            })
        );

    }

    @DeleteMapping("/{id}") //anotacion para borrar
    public ResponseEntity<?> delete(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build(); //build da una respuesta sin cuerpo
    }


}

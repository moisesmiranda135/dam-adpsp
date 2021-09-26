package com.SalesianosTriana.DAM.E02.Ejercicio02;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class InitData {

    private final MonumentosRepository repository;

    @PostConstruct
    public void init() {
        repository.saveAll(
                Arrays.asList(
                        new Monumentos ("FRA","Francia","Paris","48.85341, 2.3488","Torre Eifel","La Torre Eiffel es una construcción de hierro de 300 metros de altura que fue creada para la Exposición Universal de París de 1889.","https://www.toureiffel.paris/es"),
                        new Monumentos ("ALE","Alemania","Berlin","52.52437, 13.41053","Puerta de Brandeburgo","La puerta de Brandeburgo, obra del arquitecto Carl Gotthard Langhans, es una construcción en piedra arenisca ","https://es.wikipedia.org/wiki/Puerta_de_Brandeburgo"),
                        new Monumentos ("ARG","Argentina","Buenos Aires","-34.61315, -58.37723","Teatro Colón","El Teatro Colón inició sus actividades en 1857 en un edificio ubicado en la Plaza de Mayo","https://teatrocolon.org.ar/es")
                )

        );
    }
}

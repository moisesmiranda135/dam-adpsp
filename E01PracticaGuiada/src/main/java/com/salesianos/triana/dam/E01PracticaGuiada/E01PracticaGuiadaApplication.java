package com.salesianos.triana.dam.E01PracticaGuiada;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class E01PracticaGuiadaApplication {

	public static void main(String[] args) {
		SpringApplication.run(E01PracticaGuiadaApplication.class, args);
	}

}

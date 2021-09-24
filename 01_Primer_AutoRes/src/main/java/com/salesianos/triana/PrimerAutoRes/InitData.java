package com.salesianos.triana.PrimerAutoRes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class InitData {

    private final TaskRepository repository;

    @PostConstruct
    public void init() {
        repository.saveAll(
            Arrays.asList(
                    new Task ("a","b"),
                    new Task ("c","d"),
                    new Task ("e","f")
            )

        );
    }



}

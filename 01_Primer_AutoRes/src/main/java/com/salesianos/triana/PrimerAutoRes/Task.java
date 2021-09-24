package com.salesianos.triana.PrimerAutoRes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Task {


    @Id
    @GeneratedValue
    private Long id;

    private String tittle;

    private String text;

    public Task(String tittle, String text) {
        this.tittle = tittle;
        this.text = text;
    }
}

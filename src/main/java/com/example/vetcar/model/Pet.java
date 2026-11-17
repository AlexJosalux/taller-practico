package com.example.vetcar.model;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Pet {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Integer edad;
    private String raza;

    @ManyToOne
    private Species especie;


}


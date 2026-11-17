package com.example.vetcar.model;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class Species {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
}

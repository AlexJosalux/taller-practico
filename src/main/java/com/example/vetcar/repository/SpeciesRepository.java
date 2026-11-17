package com.example.vetcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.vetcar.model.Species;

public interface SpeciesRepository extends JpaRepository<Species,Long> {
}

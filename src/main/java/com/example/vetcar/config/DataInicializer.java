package com.example.vetcar.config;


import com.example.vetcar.repository.SpeciesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.vetcar.model.Species;

@Component
public class DataInicializer implements CommandLineRunner {
    private final SpeciesRepository speciesRepository;
    public DataInicializer(SpeciesRepository speciesRepository) {
        this.speciesRepository = speciesRepository;
    }
    @Override
    public void run(String... args){
        if (speciesRepository.count() == 0) {
            Species canino = new Species();
            canino.setNombre("Canino");
            canino.setDescripcion("Perros");
            speciesRepository.save(canino);

            Species felino = new Species();
            felino.setNombre("Felino");
            felino.setDescripcion("Gatos");
            speciesRepository.save(felino);
        }

    }
}



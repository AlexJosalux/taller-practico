package com.example.vetcar.service;

import com.example.vetcar.model.Pet;
import com.example.vetcar.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    private final PetRepository petRepository;
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }
    public List<Pet> listar() {
    return petRepository.findAll();
    }
    public Pet Buscar(Long id){
        return petRepository.findById(id).orElse(null);
    }
    public void Guardar(Pet pet){
        petRepository.save(pet);
    }
    public void Eliminar (Long id){
        petRepository.deleteById(id);
    }
}

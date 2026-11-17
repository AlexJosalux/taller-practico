package com.example.vetcar.controller;

import com.example.vetcar.model.Pet;
import com.example.vetcar.model.Species;
import org.springframework.ui.Model;
import com.example.vetcar.repository.SpeciesRepository;
import com.example.vetcar.service.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/mascotas")
public class PetController {

    private final PetService petService;
    private final SpeciesRepository speciesRepository;
    public PetController(PetService petService, SpeciesRepository speciesRepository) {
        this.petService = petService;
        this.speciesRepository = speciesRepository;
    }
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("mascotas", petService.listar());
        return "mascotas/lista";
    }
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("pet", new Pet());
        model.addAttribute("especies", speciesRepository.findAll());
        return "mascotas/form";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("pet", petService.Buscar(id));
        model.addAttribute("especies", speciesRepository.findAll());
        return "mascotas/form";
    }
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Pet pet){
        petService.Guardar(pet);
        return "redirect:/mascotas";
    }
    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id){
        petService.Eliminar(id);
        return "redirect:/mascotas";
    }
}

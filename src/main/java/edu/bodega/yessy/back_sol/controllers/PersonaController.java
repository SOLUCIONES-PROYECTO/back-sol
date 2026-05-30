package edu.bodega.yessy.back_sol.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.bodega.yessy.back_sol.models.Persona;
import edu.bodega.yessy.back_sol.services.PersonaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping
    public ArrayList<Persona> listarPersonas() {
        return personaService.listar();
    }

    @PostMapping
    public Persona nuevoPersona(@RequestBody Persona persona) {
        return personaService.nuevo(persona);
    }
}
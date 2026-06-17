package edu.bodega.yessy.back_sol.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bodega.yessy.back_sol.models.Persona;
import edu.bodega.yessy.back_sol.services.PersonaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    PersonaService personaService;
    @GetMapping
    public ArrayList<Persona> listarPersonas() {
        return personaService.listar();
    }
    @PostMapping
    public Persona nuevaPersona(@RequestBody Persona persona) {
        return personaService.nuevo(persona);
    }
}
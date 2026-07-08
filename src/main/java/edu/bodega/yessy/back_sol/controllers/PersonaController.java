package edu.bodega.yessy.back_sol.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bodega.yessy.back_sol.dto.persona.PersonaRequestDTO;
import edu.bodega.yessy.back_sol.dto.persona.PersonaResponseDTO;
import edu.bodega.yessy.back_sol.services.PersonaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public ArrayList<PersonaResponseDTO> listarPersonas() {
        return personaService.listar();
    }

    @PostMapping
    public PersonaResponseDTO nuevaPersona(
            @RequestBody PersonaRequestDTO dto) {

        return personaService.nuevo(dto);
    }

    @GetMapping("/{id}")
    public PersonaResponseDTO buscarPersona(@PathVariable Integer id) {
        return personaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public PersonaResponseDTO actualizarPersona(
            @PathVariable Integer id,
            @RequestBody PersonaRequestDTO dto) {

        return personaService.actualizar(id, dto);
    }
}
package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.models.Persona;
import edu.bodega.yessy.back_sol.repositories.PersonaRepository;

@Service
public class PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    public ArrayList<Persona> listar() {
        return (ArrayList<Persona>) personaRepository.findAll();
    }

    public Persona nuevo(Persona persona) {
        return personaRepository.save(persona);
    }
}
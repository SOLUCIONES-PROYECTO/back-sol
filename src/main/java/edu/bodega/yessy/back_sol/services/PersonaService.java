package edu.bodega.yessy.back_sol.services;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.dto.persona.PersonaRequestDTO;
import edu.bodega.yessy.back_sol.dto.persona.PersonaResponseDTO;
import edu.bodega.yessy.back_sol.models.Persona;
import edu.bodega.yessy.back_sol.repositories.PersonaRepository;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public ArrayList<PersonaResponseDTO> listar() {

        ArrayList<PersonaResponseDTO> lista = new ArrayList<>();

        for (Persona persona : personaRepository.findAll()) {
            lista.add(convertirDTO(persona));
        }

        return lista;
    }

    public PersonaResponseDTO nuevo(PersonaRequestDTO dto) {

        Persona persona = new Persona();

        persona.setNombre(dto.getNombre());
        persona.setApellido(dto.getApellido());
        persona.setDni(dto.getDni());
        persona.setTelefono(dto.getTelefono());
        persona.setCorreo(dto.getCorreo());
        persona.setDireccion(dto.getDireccion());

        persona.setFechaNacimiento(dto.getFechaNacimiento());
        persona.setGenero(dto.getGenero());

        persona.setFechaRegistro(LocalDateTime.now());

        return convertirDTO(
                personaRepository.save(persona)
        );
    }

    private PersonaResponseDTO convertirDTO(Persona persona) {

        PersonaResponseDTO dto = new PersonaResponseDTO();

        dto.setIdPersona(persona.getIdpersona());

        dto.setNombre(persona.getNombre());
        dto.setApellido(persona.getApellido());
        dto.setDni(persona.getDni());
        dto.setTelefono(persona.getTelefono());
        dto.setCorreo(persona.getCorreo());
        dto.setDireccion(persona.getDireccion());

        dto.setFechaNacimiento(persona.getFechaNacimiento());
        dto.setGenero(persona.getGenero());

        dto.setFechaRegistro(persona.getFechaRegistro());

        return dto;
    }
}
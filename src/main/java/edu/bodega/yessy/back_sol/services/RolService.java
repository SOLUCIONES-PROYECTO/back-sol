package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.dto.rol.RolRequestDTO;
import edu.bodega.yessy.back_sol.dto.rol.RolResponseDTO;
import edu.bodega.yessy.back_sol.models.Rol;
import edu.bodega.yessy.back_sol.repositories.RolRepository;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public ArrayList<RolResponseDTO> listar() {
        ArrayList<RolResponseDTO> lista = new ArrayList<>();
        for (Rol r : rolRepository.findAll()) {
            lista.add(convertirDTO(r));
        }
        return lista;
    }

    public RolResponseDTO nuevo(RolRequestDTO dto) {
        Rol r = new Rol();
        r.setNombre(dto.getNombre());
        return convertirDTO(rolRepository.save(r));
    }

    public RolResponseDTO buscar(Integer id) {
        Rol r = rolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        return convertirDTO(r);
    }

    public RolResponseDTO actualizar(Integer id, RolRequestDTO dto) {
        Rol r = rolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        r.setNombre(dto.getNombre());
        return convertirDTO(rolRepository.save(r));
    }

    public void eliminar(Integer id) {
        Rol r = rolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        rolRepository.delete(r);
    }

    private RolResponseDTO convertirDTO(Rol r) {
        RolResponseDTO dto = new RolResponseDTO();
        dto.setIdRol(r.getIdRol());
        dto.setNombre(r.getNombre());
        return dto;
    }
}
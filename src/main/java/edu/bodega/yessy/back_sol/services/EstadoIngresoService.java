package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.dto.estadoingreso.EstadoIngresoRequestDTO;
import edu.bodega.yessy.back_sol.dto.estadoingreso.EstadoIngresoResponseDTO;
import edu.bodega.yessy.back_sol.models.EstadoIngreso;
import edu.bodega.yessy.back_sol.repositories.EstadoIngresoRepository;

@Service
public class EstadoIngresoService {

    @Autowired
    private EstadoIngresoRepository estadoIngresoRepository;

    // ================= LISTAR =================
    public ArrayList<EstadoIngresoResponseDTO> listar() {

        ArrayList<EstadoIngresoResponseDTO> lista = new ArrayList<>();

        for (EstadoIngreso e : estadoIngresoRepository.findAll()) {
            lista.add(convertirDTO(e));
        }

        return lista;
    }

    // ================= CREAR =================
    public EstadoIngresoResponseDTO nuevo(EstadoIngresoRequestDTO dto) {

        EstadoIngreso e = new EstadoIngreso();

        e.setNombre(dto.getNombre());

        return convertirDTO(estadoIngresoRepository.save(e));
    }

    // ================= BUSCAR =================
    public EstadoIngresoResponseDTO buscar(Integer id) {

        EstadoIngreso e = estadoIngresoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EstadoIngreso no encontrado"));

        return convertirDTO(e);
    }

    // ================= ACTUALIZAR =================
    public EstadoIngresoResponseDTO actualizar(Integer id, EstadoIngresoRequestDTO dto) {

        EstadoIngreso e = estadoIngresoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EstadoIngreso no encontrado"));

        e.setNombre(dto.getNombre());

        return convertirDTO(estadoIngresoRepository.save(e));
    }

    // ================= ELIMINAR =================
    public void eliminar(Integer id) {

        EstadoIngreso e = estadoIngresoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EstadoIngreso no encontrado"));

        estadoIngresoRepository.delete(e);
    }

    // ================= MAPPER =================
    private EstadoIngresoResponseDTO convertirDTO(EstadoIngreso e) {

        EstadoIngresoResponseDTO dto = new EstadoIngresoResponseDTO();

        dto.setIdEstadoIngreso(e.getIdestadoIngreso());
        dto.setNombre(e.getNombre());

        return dto;
    }
}
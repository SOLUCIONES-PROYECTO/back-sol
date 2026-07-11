package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.dto.estadoproducto.EstadoProductoRequestDTO;
import edu.bodega.yessy.back_sol.dto.estadoproducto.EstadoProductoResponseDTO;
import edu.bodega.yessy.back_sol.models.EstadoProducto;
import edu.bodega.yessy.back_sol.repositories.EstadoProductoRepository;

@Service
public class EstadoProductoService {

    @Autowired
    private EstadoProductoRepository estadoProductoRepository;

    // ================= LISTAR =================
    public ArrayList<EstadoProductoResponseDTO> listar() {

        ArrayList<EstadoProductoResponseDTO> lista = new ArrayList<>();

        for (EstadoProducto e : estadoProductoRepository.findAll()) {
            lista.add(convertirDTO(e));
        }

        return lista;
    }

    // ================= CREAR =================
    public EstadoProductoResponseDTO nuevo(EstadoProductoRequestDTO dto) {

        EstadoProducto e = new EstadoProducto();

        e.setNombre(dto.getNombre());

        return convertirDTO(estadoProductoRepository.save(e));
    }

    // ================= BUSCAR =================
    public EstadoProductoResponseDTO buscar(Integer id) {

        EstadoProducto e = estadoProductoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EstadoProducto no encontrado"));

        return convertirDTO(e);
    }

    // ================= ACTUALIZAR =================
    public EstadoProductoResponseDTO actualizar(Integer id, EstadoProductoRequestDTO dto) {

        EstadoProducto e = estadoProductoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EstadoProducto no encontrado"));

        e.setNombre(dto.getNombre());

        return convertirDTO(estadoProductoRepository.save(e));
    }

    // ================= ELIMINAR =================
    public void eliminar(Integer id) {

        EstadoProducto e = estadoProductoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EstadoProducto no encontrado"));

        estadoProductoRepository.delete(e);
    }

    // ================= MAPPER =================
    private EstadoProductoResponseDTO convertirDTO(EstadoProducto e) {

        EstadoProductoResponseDTO dto = new EstadoProductoResponseDTO();

        dto.setIdEstadoProducto(e.getIdestadoproducto());
        dto.setNombre(e.getNombre());

        return dto;
    }
}
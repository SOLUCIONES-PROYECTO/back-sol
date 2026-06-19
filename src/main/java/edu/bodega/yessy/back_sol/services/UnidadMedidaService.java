package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.dto.unidadmedida.UnidadMedidaRequestDTO;
import edu.bodega.yessy.back_sol.dto.unidadmedida.UnidadMedidaResponseDTO;
import edu.bodega.yessy.back_sol.models.UnidadMedida;
import edu.bodega.yessy.back_sol.repositories.UnidadMedidaRepository;

@Service
public class UnidadMedidaService {

    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;

    // ================= LISTAR =================
    public ArrayList<UnidadMedidaResponseDTO> listar() {

        ArrayList<UnidadMedidaResponseDTO> lista = new ArrayList<>();

        for (UnidadMedida u : unidadMedidaRepository.findAll()) {
            lista.add(convertirDTO(u));
        }

        return lista;
    }

    // ================= CREAR =================
    public UnidadMedidaResponseDTO nuevo(UnidadMedidaRequestDTO dto) {

        UnidadMedida u = new UnidadMedida();

        u.setNombre(dto.getNombre());

        return convertirDTO(unidadMedidaRepository.save(u));
    }

    // ================= BUSCAR =================
    public UnidadMedidaResponseDTO buscar(Integer id) {

        UnidadMedida u = unidadMedidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Unidad de Medida no encontrada"));

        return convertirDTO(u);
    }

    // ================= ACTUALIZAR =================
    public UnidadMedidaResponseDTO actualizar(Integer id, UnidadMedidaRequestDTO dto) {

        UnidadMedida u = unidadMedidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Unidad de Medida no encontrada"));

        u.setNombre(dto.getNombre());

        return convertirDTO(unidadMedidaRepository.save(u));
    }

    // ================= ELIMINAR =================
    public void eliminar(Integer id) {

        UnidadMedida u = unidadMedidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Unidad de Medida no encontrada"));

        unidadMedidaRepository.delete(u);
    }

    // ================= MAPPER =================
    private UnidadMedidaResponseDTO convertirDTO(UnidadMedida u) {

        UnidadMedidaResponseDTO dto = new UnidadMedidaResponseDTO();

        dto.setIdUnidadMedida(u.getIdunidadMedida());
        dto.setNombre(u.getNombre());

        return dto;
    }
}
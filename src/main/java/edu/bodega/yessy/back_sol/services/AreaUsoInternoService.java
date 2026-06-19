package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.dto.areausointerno.AreaUsoInternoRequestDTO;
import edu.bodega.yessy.back_sol.dto.areausointerno.AreaUsoInternoResponseDTO;
import edu.bodega.yessy.back_sol.models.AreaUsoInterno;
import edu.bodega.yessy.back_sol.repositories.AreaUsoInternoRepository;

@Service
public class AreaUsoInternoService {

    @Autowired
    private AreaUsoInternoRepository areaUsoInternoRepository;

    // ================= LISTAR =================
    public ArrayList<AreaUsoInternoResponseDTO> listar() {

        ArrayList<AreaUsoInternoResponseDTO> lista = new ArrayList<>();

        for (AreaUsoInterno a : areaUsoInternoRepository.findAll()) {
            lista.add(convertirDTO(a));
        }

        return lista;
    }

    // ================= CREAR =================
    public AreaUsoInternoResponseDTO nuevo(AreaUsoInternoRequestDTO dto) {

        AreaUsoInterno a = new AreaUsoInterno();

        a.setNombre(dto.getNombre());

        return convertirDTO(areaUsoInternoRepository.save(a));
    }

    // ================= BUSCAR =================
    public AreaUsoInternoResponseDTO buscar(Integer id) {

        AreaUsoInterno a = areaUsoInternoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Área de uso interno no encontrada"));

        return convertirDTO(a);
    }

    // ================= ACTUALIZAR =================
    public AreaUsoInternoResponseDTO actualizar(Integer id, AreaUsoInternoRequestDTO dto) {

        AreaUsoInterno a = areaUsoInternoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Área de uso interno no encontrada"));

        a.setNombre(dto.getNombre());

        return convertirDTO(areaUsoInternoRepository.save(a));
    }

    // ================= ELIMINAR =================
    public void eliminar(Integer id) {

        AreaUsoInterno a = areaUsoInternoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Área de uso interno no encontrada"));

        areaUsoInternoRepository.delete(a);
    }

    // ================= MAPPER =================
    private AreaUsoInternoResponseDTO convertirDTO(AreaUsoInterno a) {

        AreaUsoInternoResponseDTO dto = new AreaUsoInternoResponseDTO();

        dto.setIdAreaUsoInterno(a.getIdAreaUsoInterno());
        dto.setNombre(a.getNombre());

        return dto;
    }
}

package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.dto.area.AreaRequestDTO;
import edu.bodega.yessy.back_sol.dto.area.AreaResponseDTO;
import edu.bodega.yessy.back_sol.models.Area;
import edu.bodega.yessy.back_sol.repositories.AreaRepository;

@Service
public class AreaService {

    @Autowired
    private AreaRepository areaRepository;

    public ArrayList<AreaResponseDTO> listar() {
        ArrayList<AreaResponseDTO> lista = new ArrayList<>();
        for (Area a : areaRepository.findAll()) {
            lista.add(convertirDTO(a));
        }
        return lista;
    }

    public AreaResponseDTO nuevo(AreaRequestDTO dto) {
        Area a = new Area();
        a.setNombre(dto.getNombre());
        return convertirDTO(areaRepository.save(a));
    }

    public AreaResponseDTO buscar(Integer id) {
        Area a = areaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Área no encontrada"));
        return convertirDTO(a);
    }

    public AreaResponseDTO actualizar(Integer id, AreaRequestDTO dto) {
        Area a = areaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Área no encontrada"));
        a.setNombre(dto.getNombre());
        return convertirDTO(areaRepository.save(a));
    }

    public void eliminar(Integer id) {
        Area a = areaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Área no encontrada"));
        areaRepository.delete(a);
    }

    private AreaResponseDTO convertirDTO(Area a) {
        AreaResponseDTO dto = new AreaResponseDTO();
        dto.setIdArea(a.getIdArea());
        dto.setNombre(a.getNombre());
        return dto;
    }
}

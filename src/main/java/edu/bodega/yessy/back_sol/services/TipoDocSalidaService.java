package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.dto.tipodocsalida.TipoDocSalidaRequestDTO;
import edu.bodega.yessy.back_sol.dto.tipodocsalida.TipoDocSalidaResponseDTO;
import edu.bodega.yessy.back_sol.models.TipoDocSalida;
import edu.bodega.yessy.back_sol.repositories.TipoDocSalidaRepository;

@Service
public class TipoDocSalidaService {

    @Autowired
    private TipoDocSalidaRepository tipoDocSalidaRepository;

    public ArrayList<TipoDocSalidaResponseDTO> listar() {

        ArrayList<TipoDocSalidaResponseDTO> lista = new ArrayList<>();

        for (TipoDocSalida t : tipoDocSalidaRepository.findAll()) {
            lista.add(convertirDTO(t));
        }

        return lista;
    }

    public TipoDocSalidaResponseDTO nuevo(TipoDocSalidaRequestDTO dto) {

        TipoDocSalida t = new TipoDocSalida();

        t.setNombre(dto.getNombre());
        t.setDescripcion(dto.getDescripcion());

        return convertirDTO(tipoDocSalidaRepository.save(t));
    }

    public TipoDocSalidaResponseDTO buscar(Integer id) {

        TipoDocSalida t = tipoDocSalidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TipoDocSalida no encontrado"));

        return convertirDTO(t);
    }

    public TipoDocSalidaResponseDTO actualizar(Integer id, TipoDocSalidaRequestDTO dto) {

        TipoDocSalida t = tipoDocSalidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TipoDocSalida no encontrado"));

        t.setNombre(dto.getNombre());
        t.setDescripcion(dto.getDescripcion());

        return convertirDTO(tipoDocSalidaRepository.save(t));
    }

    public void eliminar(Integer id) {

        TipoDocSalida t = tipoDocSalidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TipoDocSalida no encontrado"));

        tipoDocSalidaRepository.delete(t);
    }

    private TipoDocSalidaResponseDTO convertirDTO(TipoDocSalida t) {

        TipoDocSalidaResponseDTO dto = new TipoDocSalidaResponseDTO();

        dto.setIdTipoDocSalida(t.getIdtipodocsalida());
        dto.setNombre(t.getNombre());
        dto.setDescripcion(t.getDescripcion());

        return dto;
    }
}
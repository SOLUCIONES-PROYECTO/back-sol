package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.dto.tipodocentrada.TipoDocEntradaRequestDTO;
import edu.bodega.yessy.back_sol.dto.tipodocentrada.TipoDocEntradaResponseDTO;
import edu.bodega.yessy.back_sol.models.TipoDocEntrada;
import edu.bodega.yessy.back_sol.repositories.TipoDocEntradaRepository;

@Service
public class TipoDocEntradaService {

    @Autowired
    private TipoDocEntradaRepository tipoDocEntradaRepository;

    public ArrayList<TipoDocEntradaResponseDTO> listar() {

        ArrayList<TipoDocEntradaResponseDTO> lista = new ArrayList<>();

        for (TipoDocEntrada e : tipoDocEntradaRepository.findAll()) {
            lista.add(convertirDTO(e));
        }

        return lista;
    }

    public TipoDocEntradaResponseDTO nuevo(TipoDocEntradaRequestDTO dto) {

        TipoDocEntrada e = new TipoDocEntrada();

        e.setNombre(dto.getNombre());
        e.setDescripcion(dto.getDescripcion());

        return convertirDTO(tipoDocEntradaRepository.save(e));
    }

    public TipoDocEntradaResponseDTO buscar(Integer id) {

        TipoDocEntrada e = tipoDocEntradaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TipoDocEntrada no encontrado"));

        return convertirDTO(e);
    }

    public TipoDocEntradaResponseDTO actualizar(Integer id, TipoDocEntradaRequestDTO dto) {

        TipoDocEntrada e = tipoDocEntradaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TipoDocEntrada no encontrado"));

        e.setNombre(dto.getNombre());
        e.setDescripcion(dto.getDescripcion());

        return convertirDTO(tipoDocEntradaRepository.save(e));
    }

    public void eliminar(Integer id) {

        TipoDocEntrada e = tipoDocEntradaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TipoDocEntrada no encontrado"));

        tipoDocEntradaRepository.delete(e);
    }

    private TipoDocEntradaResponseDTO convertirDTO(TipoDocEntrada e) {

        TipoDocEntradaResponseDTO dto = new TipoDocEntradaResponseDTO();

        dto.setIdTipoDocEntrada(e.getIdtipodocentrada());
        dto.setNombre(e.getNombre());
        dto.setDescripcion(e.getDescripcion());

        return dto;
    }
}
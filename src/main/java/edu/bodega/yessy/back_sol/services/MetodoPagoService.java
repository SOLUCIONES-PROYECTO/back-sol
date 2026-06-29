package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.dto.metodopago.MetodoPagoRequestDTO;
import edu.bodega.yessy.back_sol.dto.metodopago.MetodoPagoResponseDTO;
import edu.bodega.yessy.back_sol.models.MetodoPago;
import edu.bodega.yessy.back_sol.repositories.MetodoPagoRepository;

@Service
public class MetodoPagoService {

    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    public ArrayList<MetodoPagoResponseDTO> listar() {

        ArrayList<MetodoPagoResponseDTO> lista = new ArrayList<>();

        for (MetodoPago m : metodoPagoRepository.findAll()) {
            lista.add(convertirDTO(m));
        }

        return lista;
    }

    public MetodoPagoResponseDTO nuevo(MetodoPagoRequestDTO dto) {

        MetodoPago m = new MetodoPago();

        m.setNombre(dto.getNombre());

        return convertirDTO(metodoPagoRepository.save(m));
    }

    public MetodoPagoResponseDTO buscar(Integer id) {

        MetodoPago m = metodoPagoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("MetodoPago no encontrado"));

        return convertirDTO(m);
    }

    public MetodoPagoResponseDTO actualizar(Integer id, MetodoPagoRequestDTO dto) {

        MetodoPago m = metodoPagoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("MetodoPago no encontrado"));

        m.setNombre(dto.getNombre());

        return convertirDTO(metodoPagoRepository.save(m));
    }

    public void eliminar(Integer id) {

        MetodoPago m = metodoPagoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("MetodoPago no encontrado"));

        metodoPagoRepository.delete(m);
    }

    private MetodoPagoResponseDTO convertirDTO(MetodoPago m) {

        MetodoPagoResponseDTO dto = new MetodoPagoResponseDTO();

        dto.setIdMetodoPago(m.getIdmetododepago());
        dto.setNombre(m.getNombre());

        return dto;
    }
}

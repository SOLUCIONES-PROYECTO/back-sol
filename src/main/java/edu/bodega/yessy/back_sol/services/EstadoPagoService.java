package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.dto.estadopago.EstadoPagoRequestDTO;
import edu.bodega.yessy.back_sol.dto.estadopago.EstadoPagoResponseDTO;
import edu.bodega.yessy.back_sol.models.EstadoPago;
import edu.bodega.yessy.back_sol.repositories.EstadoPagoRepository;

@Service
public class EstadoPagoService {

    @Autowired
    private EstadoPagoRepository estadoPagoRepository;

    // ================= LISTAR =================
    public ArrayList<EstadoPagoResponseDTO> listar() {

        ArrayList<EstadoPagoResponseDTO> lista = new ArrayList<>();

        for (EstadoPago e : estadoPagoRepository.findAll()) {
            lista.add(convertirDTO(e));
        }

        return lista;
    }

    // ================= CREAR =================
    public EstadoPagoResponseDTO nuevo(EstadoPagoRequestDTO dto) {

        EstadoPago e = new EstadoPago();

        e.setNombre(dto.getNombre());

        return convertirDTO(estadoPagoRepository.save(e));
    }

    // ================= BUSCAR =================
    public EstadoPagoResponseDTO buscar(Integer id) {

        EstadoPago e = estadoPagoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EstadoPago no encontrado"));

        return convertirDTO(e);
    }

    // ================= ACTUALIZAR =================
    public EstadoPagoResponseDTO actualizar(Integer id, EstadoPagoRequestDTO dto) {

        EstadoPago e = estadoPagoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EstadoPago no encontrado"));

        e.setNombre(dto.getNombre());

        return convertirDTO(estadoPagoRepository.save(e));
    }

    // ================= ELIMINAR =================
    public void eliminar(Integer id) {

        EstadoPago e = estadoPagoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EstadoPago no encontrado"));

        estadoPagoRepository.delete(e);
    }

    // ================= MAPPER =================
    private EstadoPagoResponseDTO convertirDTO(EstadoPago e) {

        EstadoPagoResponseDTO dto = new EstadoPagoResponseDTO();

        dto.setIdEstadoPago(e.getIdestadoPago());
        dto.setNombre(e.getNombre());

        return dto;
    }
}
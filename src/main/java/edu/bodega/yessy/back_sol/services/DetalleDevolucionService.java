package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.dto.detalledevolucion.DetalleDevolucionRequestDTO;
import edu.bodega.yessy.back_sol.dto.detalledevolucion.DetalleDevolucionResponseDTO;
import edu.bodega.yessy.back_sol.models.DetalleDevolucion;
import edu.bodega.yessy.back_sol.models.DetalleSalida;
import edu.bodega.yessy.back_sol.repositories.DetalleDevolucionRepository;
import edu.bodega.yessy.back_sol.repositories.DetalleSalidaRepository;

@Service
public class DetalleDevolucionService {

    @Autowired
    private DetalleDevolucionRepository detalleDevolucionRepository;

    @Autowired
    private DetalleSalidaRepository detalleSalidaRepository;

    // ================= LISTAR =================
    public ArrayList<DetalleDevolucionResponseDTO> listar() {

        ArrayList<DetalleDevolucionResponseDTO> lista = new ArrayList<>();

        for (DetalleDevolucion e : detalleDevolucionRepository.findAll()) {
            lista.add(convertirDTO(e));
        }

        return lista;
    }

    // ================= CREAR =================
    public DetalleDevolucionResponseDTO nuevo(DetalleDevolucionRequestDTO dto) {

        DetalleSalida detalleSalida = detalleSalidaRepository.findById(dto.getIdDetalleSalida())
                .orElseThrow(() -> new RuntimeException("DetalleSalida no encontrado"));

        DetalleDevolucion e = new DetalleDevolucion();

        e.setDetalleSalida(detalleSalida);
        e.setMotivo(dto.getMotivo());

        return convertirDTO(detalleDevolucionRepository.save(e));
    }

    // ================= BUSCAR =================
    public DetalleDevolucionResponseDTO buscar(Integer id) {

        DetalleDevolucion e = detalleDevolucionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DetalleDevolucion no encontrado"));

        return convertirDTO(e);
    }

    // ================= ACTUALIZAR =================
    public DetalleDevolucionResponseDTO actualizar(Integer id, DetalleDevolucionRequestDTO dto) {

        DetalleDevolucion e = detalleDevolucionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DetalleDevolucion no encontrado"));

        DetalleSalida detalleSalida = detalleSalidaRepository.findById(dto.getIdDetalleSalida())
                .orElseThrow(() -> new RuntimeException("DetalleSalida no encontrado"));

        e.setDetalleSalida(detalleSalida);
        e.setMotivo(dto.getMotivo());

        return convertirDTO(detalleDevolucionRepository.save(e));
    }

    // ================= ELIMINAR =================
    public void eliminar(Integer id) {

        DetalleDevolucion e = detalleDevolucionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DetalleDevolucion no encontrado"));

        detalleDevolucionRepository.delete(e);
    }

    // ================= MAPPER =================
    private DetalleDevolucionResponseDTO convertirDTO(DetalleDevolucion e) {

        DetalleDevolucionResponseDTO dto = new DetalleDevolucionResponseDTO();

        dto.setIdDetalleDevolucion(e.getIddetalleDevolucion());

        dto.setIdDetalleSalida(e.getDetalleSalida().getIddetalleSalida());

        dto.setIdProducto(e.getDetalleSalida().getProducto().getIdproducto());
        dto.setNombreProducto(e.getDetalleSalida().getProducto().getNombre());

        dto.setIdDocSalida(e.getDetalleSalida().getDocSalida().getIddocsalida());
        dto.setNumeroDocumentoSalida(e.getDetalleSalida().getDocSalida().getNumeroDocumento());

        dto.setMotivo(e.getMotivo());

        return dto;
    }
}

package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.dto.detallenea.DetalleNeaRequestDTO;
import edu.bodega.yessy.back_sol.dto.detallenea.DetalleNeaResponseDTO;
import edu.bodega.yessy.back_sol.models.DetalleEntrada;
import edu.bodega.yessy.back_sol.models.DetalleNea;
import edu.bodega.yessy.back_sol.models.Proveedor;
import edu.bodega.yessy.back_sol.repositories.DetalleEntradaRepository;
import edu.bodega.yessy.back_sol.repositories.DetalleNeaRepository;
import edu.bodega.yessy.back_sol.repositories.ProveedorRepository;

@Service
public class DetalleNeaService {

    @Autowired
    private DetalleNeaRepository detalleNeaRepository;

    @Autowired
    private DetalleEntradaRepository detalleEntradaRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    // ================= LISTAR =================
    public ArrayList<DetalleNeaResponseDTO> listar() {

        ArrayList<DetalleNeaResponseDTO> lista = new ArrayList<>();

        for (DetalleNea e : detalleNeaRepository.findAll()) {
            lista.add(convertirDTO(e));
        }

        return lista;
    }

    // ================= CREAR =================
    public DetalleNeaResponseDTO nuevo(DetalleNeaRequestDTO dto) {

        DetalleEntrada detalleEntrada = detalleEntradaRepository.findById(dto.getIdDetalleEntrada())
                .orElseThrow(() -> new RuntimeException("DetalleEntrada no encontrado"));

        Proveedor proveedor = proveedorRepository.findById(dto.getIdProveedor())
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        DetalleNea e = new DetalleNea();

        e.setDetalleEntrada(detalleEntrada);
        e.setProveedor(proveedor);

        e.setMotivo(dto.getMotivo());
        e.setObservaciones(dto.getObservaciones());

        return convertirDTO(detalleNeaRepository.save(e));
    }

    // ================= BUSCAR =================
    public DetalleNeaResponseDTO buscar(Integer id) {

        DetalleNea e = detalleNeaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DetalleNea no encontrado"));

        return convertirDTO(e);
    }

    // ================= ACTUALIZAR =================
    public DetalleNeaResponseDTO actualizar(Integer id, DetalleNeaRequestDTO dto) {

        DetalleNea e = detalleNeaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DetalleNea no encontrado"));

        DetalleEntrada detalleEntrada = detalleEntradaRepository.findById(dto.getIdDetalleEntrada())
                .orElseThrow(() -> new RuntimeException("DetalleEntrada no encontrado"));

        Proveedor proveedor = proveedorRepository.findById(dto.getIdProveedor())
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        e.setDetalleEntrada(detalleEntrada);
        e.setProveedor(proveedor);

        e.setMotivo(dto.getMotivo());
        e.setObservaciones(dto.getObservaciones());

        return convertirDTO(detalleNeaRepository.save(e));
    }

    // ================= ELIMINAR =================
    public void eliminar(Integer id) {

        DetalleNea e = detalleNeaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DetalleNea no encontrado"));

        detalleNeaRepository.delete(e);
    }

    // ================= MAPPER =================
    private DetalleNeaResponseDTO convertirDTO(DetalleNea e) {

        DetalleNeaResponseDTO dto = new DetalleNeaResponseDTO();

        dto.setIdDetalleNea(e.getIddetalleNea());

        dto.setIdDetalleEntrada(e.getDetalleEntrada().getIddetalleEntrada());

        dto.setIdProducto(e.getDetalleEntrada().getProducto().getIdproducto());
        dto.setNombreProducto(e.getDetalleEntrada().getProducto().getNombre());

        dto.setNumeroDocumentoEntrada(
                e.getDetalleEntrada().getDocEntrada().getNumeroDocumento()
        );

        dto.setIdProveedor(e.getProveedor().getIdProveedor());
        dto.setNombreProveedor(e.getProveedor().getDescripcion());

        dto.setMotivo(e.getMotivo());
        dto.setObservaciones(e.getObservaciones());

        return dto;
    }
}
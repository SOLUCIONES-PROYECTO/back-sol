package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.dto.detallesalida.DetalleSalidaRequestDTO;
import edu.bodega.yessy.back_sol.dto.detallesalida.DetalleSalidaResponseDTO;
import edu.bodega.yessy.back_sol.models.DetalleSalida;
import edu.bodega.yessy.back_sol.models.DocSalida;
import edu.bodega.yessy.back_sol.models.Producto;
import edu.bodega.yessy.back_sol.repositories.DetalleSalidaRepository;
import edu.bodega.yessy.back_sol.repositories.DocSalidaRepository;
import edu.bodega.yessy.back_sol.repositories.ProductoRepository;

@Service
public class DetalleSalidaService {

    @Autowired
    private DetalleSalidaRepository detalleSalidaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private DocSalidaRepository docSalidaRepository;

    // ================= LISTAR =================
    public ArrayList<DetalleSalidaResponseDTO> listar() {

        ArrayList<DetalleSalidaResponseDTO> lista = new ArrayList<>();

        for (DetalleSalida e : detalleSalidaRepository.findAll()) {
            lista.add(convertirDTO(e));
        }

        return lista;
    }

    // ================= CREAR =================
    public DetalleSalidaResponseDTO nuevo(DetalleSalidaRequestDTO dto) {

        Producto producto = productoRepository.findById(dto.getIdProducto())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        DocSalida docSalida = docSalidaRepository.findById(dto.getIdDocSalida())
                .orElseThrow(() -> new RuntimeException("DocSalida no encontrado"));

        // 🔥 VALIDACIÓN DE STOCK
        if (producto.getStockActual() < dto.getCantidad()) {
            throw new org.springframework.web.server.ResponseStatusException(
                org.springframework.http.HttpStatus.BAD_REQUEST, 
                "Stock insuficiente para el producto '" + producto.getNombre() + "'. Disponible: " + producto.getStockActual() + ", Solicitado: " + dto.getCantidad()
            );
        }

        // 🔥 DESCONTAR STOCK
        producto.setStockActual(producto.getStockActual() - dto.getCantidad());
        productoRepository.save(producto);

        DetalleSalida e = new DetalleSalida();

        e.setProducto(producto);
        e.setDocSalida(docSalida);

        e.setCantidad(dto.getCantidad());
        e.setPrecioUnitario(dto.getPrecioUnitario());
        e.setSubtotal(dto.getSubtotal());

        return convertirDTO(detalleSalidaRepository.save(e));
    }

    // ================= BUSCAR =================
    public DetalleSalidaResponseDTO buscar(Integer id) {

        DetalleSalida e = detalleSalidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DetalleSalida no encontrado"));

        return convertirDTO(e);
    }

    // ================= ACTUALIZAR =================
    public DetalleSalidaResponseDTO actualizar(Integer id, DetalleSalidaRequestDTO dto) {

        DetalleSalida e = detalleSalidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DetalleSalida no encontrado"));

        Producto producto = productoRepository.findById(dto.getIdProducto())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        DocSalida docSalida = docSalidaRepository.findById(dto.getIdDocSalida())
                .orElseThrow(() -> new RuntimeException("DocSalida no encontrado"));

        e.setProducto(producto);
        e.setDocSalida(docSalida);

        e.setCantidad(dto.getCantidad());
        e.setPrecioUnitario(dto.getPrecioUnitario());
        e.setSubtotal(dto.getSubtotal());

        return convertirDTO(detalleSalidaRepository.save(e));
    }

    // ================= ELIMINAR =================
    public void eliminar(Integer id) {

        DetalleSalida e = detalleSalidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DetalleSalida no encontrado"));

        detalleSalidaRepository.delete(e);
    }

    // ================= MAPPER =================
    private DetalleSalidaResponseDTO convertirDTO(DetalleSalida e) {

        DetalleSalidaResponseDTO dto = new DetalleSalidaResponseDTO();

        dto.setIdDetalleSalida(e.getIddetalleSalida());

        dto.setIdProducto(e.getProducto().getIdproducto());
        dto.setNombreProducto(e.getProducto().getNombre());

        dto.setIdDocSalida(e.getDocSalida().getIddocsalida());
        dto.setNumeroDocumentoSalida(e.getDocSalida().getNumeroDocumento());

        dto.setCantidad(e.getCantidad());
        dto.setPrecioUnitario(e.getPrecioUnitario());
        dto.setSubtotal(e.getSubtotal());

        return dto;
    }
}
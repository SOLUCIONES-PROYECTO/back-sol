package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.dto.detallemerma.DetalleMermaRequestDTO;
import edu.bodega.yessy.back_sol.dto.detallemerma.DetalleMermaResponseDTO;
import edu.bodega.yessy.back_sol.models.DetalleMerma;
import edu.bodega.yessy.back_sol.models.DetalleSalida;
import edu.bodega.yessy.back_sol.models.Producto;
import edu.bodega.yessy.back_sol.repositories.DetalleMermaRepository;
import edu.bodega.yessy.back_sol.repositories.DetalleSalidaRepository;
import edu.bodega.yessy.back_sol.repositories.ProductoRepository;

@Service
public class DetalleMermaService {

    @Autowired
    private DetalleMermaRepository detalleMermaRepository;

    @Autowired
    private DetalleSalidaRepository detalleSalidaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    // ================= LISTAR =================
    public ArrayList<DetalleMermaResponseDTO> listar() {

        ArrayList<DetalleMermaResponseDTO> lista = new ArrayList<>();

        for (DetalleMerma e : detalleMermaRepository.findAll()) {
            lista.add(convertirDTO(e));
        }

        return lista;
    }

    // ================= CREAR =================
    public DetalleMermaResponseDTO nuevo(DetalleMermaRequestDTO dto) {

        DetalleSalida detalleSalida = detalleSalidaRepository.findById(dto.getIdDetalleSalida())
                .orElseThrow(() -> new RuntimeException("DetalleSalida no encontrado"));

        Producto producto = detalleSalida.getProducto();

        // 🔥 DESCONTAR STOCK POR MERMA
        if (producto.getStockActual() < 1) {
            throw new RuntimeException("No hay stock disponible para registrar merma");
        }

        producto.setStockActual(producto.getStockActual() - 1);
        productoRepository.save(producto);

        DetalleMerma e = new DetalleMerma();

        e.setDetalleSalida(detalleSalida);
        e.setMotivoMerma(dto.getMotivoMerma());
        e.setDescripcion(dto.getDescripcion());

        return convertirDTO(detalleMermaRepository.save(e));
    }

    // ================= BUSCAR =================
    public DetalleMermaResponseDTO buscar(Integer id) {

        DetalleMerma e = detalleMermaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DetalleMerma no encontrado"));

        return convertirDTO(e);
    }

    // ================= ACTUALIZAR =================
    public DetalleMermaResponseDTO actualizar(Integer id, DetalleMermaRequestDTO dto) {

        DetalleMerma e = detalleMermaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DetalleMerma no encontrado"));

        DetalleSalida detalleSalida = detalleSalidaRepository.findById(dto.getIdDetalleSalida())
                .orElseThrow(() -> new RuntimeException("DetalleSalida no encontrado"));

        e.setDetalleSalida(detalleSalida);
        e.setMotivoMerma(dto.getMotivoMerma());
        e.setDescripcion(dto.getDescripcion());

        return convertirDTO(detalleMermaRepository.save(e));
    }

    // ================= ELIMINAR =================
    public void eliminar(Integer id) {

        DetalleMerma e = detalleMermaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DetalleMerma no encontrado"));

        detalleMermaRepository.delete(e);
    }

    // ================= MAPPER =================
    private DetalleMermaResponseDTO convertirDTO(DetalleMerma e) {

        DetalleMermaResponseDTO dto = new DetalleMermaResponseDTO();

        dto.setIdDetalleMerma(e.getIddetalleMerma());

        dto.setIdDetalleSalida(e.getDetalleSalida().getIddetalleSalida());
        dto.setIdProducto(e.getDetalleSalida().getProducto().getIdproducto());
        dto.setNombreProducto(e.getDetalleSalida().getProducto().getNombre());
        dto.setNumeroDocumentoSalida(
                e.getDetalleSalida().getDocSalida().getNumeroDocumento()
        );

        dto.setMotivoMerma(e.getMotivoMerma());
        dto.setDescripcion(e.getDescripcion());

        return dto;
    }
}

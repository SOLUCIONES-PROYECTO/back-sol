package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.dto.detalleusointerno.DetalleUsoInternoRequestDTO;
import edu.bodega.yessy.back_sol.dto.detalleusointerno.DetalleUsoInternoResponseDTO;
import edu.bodega.yessy.back_sol.models.AreaUsoInterno;
import edu.bodega.yessy.back_sol.models.DetalleSalida;
import edu.bodega.yessy.back_sol.models.DetalleUsoInterno;
import edu.bodega.yessy.back_sol.repositories.AreaUsoInternoRepository;
import edu.bodega.yessy.back_sol.repositories.DetalleSalidaRepository;
import edu.bodega.yessy.back_sol.repositories.DetalleUsoInternoRepository;
import edu.bodega.yessy.back_sol.repositories.ProductoRepository;

@Service
public class DetalleUsoInternoService {

    @Autowired
    private DetalleUsoInternoRepository detalleUsoInternoRepository;

    @Autowired
    private DetalleSalidaRepository detalleSalidaRepository;

    @Autowired
    private AreaUsoInternoRepository areaUsoInternoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    // ================= LISTAR =================
    public ArrayList<DetalleUsoInternoResponseDTO> listar() {

        ArrayList<DetalleUsoInternoResponseDTO> lista = new ArrayList<>();

        for (DetalleUsoInterno e : detalleUsoInternoRepository.findAll()) {
            lista.add(convertirDTO(e));
        }

        return lista;
    }

    // ================= CREAR =================
    public DetalleUsoInternoResponseDTO nuevo(DetalleUsoInternoRequestDTO dto) {

        DetalleSalida detalleSalida = detalleSalidaRepository.findById(dto.getIdDetalleSalida())
                .orElseThrow(() -> new RuntimeException("DetalleSalida no encontrado"));

        AreaUsoInterno area = areaUsoInternoRepository.findById(dto.getIdAreaUsoInterno())
                .orElseThrow(() -> new RuntimeException("Área de uso interno no encontrada"));

        DetalleUsoInterno e = new DetalleUsoInterno();

        e.setDetalleSalida(detalleSalida);
        e.setAreausoInterno(area);
        e.setDescripcion(dto.getDescripcion());

        return convertirDTO(detalleUsoInternoRepository.save(e));
    }

    // ================= BUSCAR =================
    public DetalleUsoInternoResponseDTO buscar(Integer id) {

        DetalleUsoInterno e = detalleUsoInternoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DetalleUsoInterno no encontrado"));

        return convertirDTO(e);
    }

    // ================= ACTUALIZAR =================
    public DetalleUsoInternoResponseDTO actualizar(Integer id, DetalleUsoInternoRequestDTO dto) {

        DetalleUsoInterno e = detalleUsoInternoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DetalleUsoInterno no encontrado"));

        DetalleSalida detalleSalida = detalleSalidaRepository.findById(dto.getIdDetalleSalida())
                .orElseThrow(() -> new RuntimeException("DetalleSalida no encontrado"));

        AreaUsoInterno area = areaUsoInternoRepository.findById(dto.getIdAreaUsoInterno())
                .orElseThrow(() -> new RuntimeException("Área de uso interno no encontrada"));

        e.setDetalleSalida(detalleSalida);
        e.setAreausoInterno(area);
        e.setDescripcion(dto.getDescripcion());

        return convertirDTO(detalleUsoInternoRepository.save(e));
    }

    // ================= ELIMINAR =================
    public void eliminar(Integer id) {

        DetalleUsoInterno e = detalleUsoInternoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DetalleUsoInterno no encontrado"));

        detalleUsoInternoRepository.delete(e);
    }

    // ================= MAPPER =================
    private DetalleUsoInternoResponseDTO convertirDTO(DetalleUsoInterno e) {

        DetalleUsoInternoResponseDTO dto = new DetalleUsoInternoResponseDTO();

        dto.setIdDetalleUsoInterno(e.getIddetalleusoInterno());

        dto.setIdAreaUsoInterno(e.getAreausoInterno().getIdAreaUsoInterno());
        dto.setNombreAreaUsoInterno(e.getAreausoInterno().getNombre());

        dto.setIdDetalleSalida(e.getDetalleSalida().getIddetalleSalida());
        dto.setIdProducto(e.getDetalleSalida().getProducto().getIdproducto());
        dto.setNombreProducto(e.getDetalleSalida().getProducto().getNombre());
        dto.setNumeroDocumentoSalida(
                e.getDetalleSalida().getDocSalida().getNumeroDocumento()
        );

        dto.setDescripcion(e.getDescripcion());

        return dto;
    }
}

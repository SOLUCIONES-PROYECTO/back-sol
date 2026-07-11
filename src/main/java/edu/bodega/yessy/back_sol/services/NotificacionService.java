package edu.bodega.yessy.back_sol.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.dto.notificacion.NotificacionResponseDTO;
import edu.bodega.yessy.back_sol.models.DetalleEntrada;
import edu.bodega.yessy.back_sol.models.DocEntrada;
import edu.bodega.yessy.back_sol.models.DocSalida;
import edu.bodega.yessy.back_sol.models.Producto;
import edu.bodega.yessy.back_sol.repositories.DetalleEntradaRepository;
import edu.bodega.yessy.back_sol.repositories.DocEntradaRepository;
import edu.bodega.yessy.back_sol.repositories.DocSalidaRepository;
import edu.bodega.yessy.back_sol.repositories.ProductoRepository;

@Service
public class NotificacionService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private DetalleEntradaRepository detalleEntradaRepository;

    @Autowired
    private DocEntradaRepository docEntradaRepository;

    @Autowired
    private DocSalidaRepository docSalidaRepository;

    public List<NotificacionResponseDTO> obtenerAlertas() {
        List<NotificacionResponseDTO> alertas = new ArrayList<>();

        // 1. Alertas de Stock (Bajo Stock)
        List<Producto> productos = productoRepository.findAll();
        for (Producto p : productos) {
            if (p.getStockActual() <= p.getStockMinimo()) {
                alertas.add(new NotificacionResponseDTO(
                        "Stock", 
                        "El producto '" + p.getNombre() + "' tiene stock bajo (" + p.getStockActual() + ").",
                        "/productos"
                ));
            }
        }

        // 2. Alertas de Vencimiento (Menos de 30 días)
        LocalDate hoy = LocalDate.now();
        LocalDate limite = hoy.plusDays(30);
        List<DetalleEntrada> detalles = detalleEntradaRepository.findAll();
        for (DetalleEntrada d : detalles) {
            if (d.getFechavencimiento() != null && d.getFechavencimiento().isBefore(limite)) {
                String mensaje = d.getFechavencimiento().isBefore(hoy) 
                    ? "El lote '" + d.getLoteproducto() + "' del producto '" + d.getProducto().getNombre() + "' ha vencido."
                    : "El lote '" + d.getLoteproducto() + "' del producto '" + d.getProducto().getNombre() + "' vencerá pronto (" + d.getFechavencimiento() + ").";
                
                alertas.add(new NotificacionResponseDTO("Vencimiento", mensaje, "/productos"));
            }
        }

        // 3. Facturas Pendientes (Ingresos y Egresos)
        List<DocEntrada> ingresos = docEntradaRepository.findAll();
        for (DocEntrada doc : ingresos) {
            if (doc.getEstadoPago() != null && "Pendiente".equalsIgnoreCase(doc.getEstadoPago().getNombre())) {
                alertas.add(new NotificacionResponseDTO(
                        "Ingreso Pendiente", 
                        "El ingreso '" + doc.getNumeroDocumento() + "' está pendiente de pago.",
                        "/ingresos"
                ));
            }
        }

        // Egresos no tienen estado_pago explícito por ahora.
        /* List<DocSalida> egresos = docSalidaRepository.findAll();
        for (DocSalida doc : egresos) {
            // Lógica pendiente cuando exista estado en DocSalida
        } */

        return alertas;
    }
}

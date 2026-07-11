package edu.bodega.yessy.back_sol.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.dto.detalleordencompra.DetalleOrdenCompraRequest;
import edu.bodega.yessy.back_sol.dto.detalleordencompra.DetalleOrdenCompraResponse;
import edu.bodega.yessy.back_sol.dto.ordencompra.OrdenCompraRequest;
import edu.bodega.yessy.back_sol.dto.ordencompra.OrdenCompraResponse;
import edu.bodega.yessy.back_sol.models.DetalleOrdenCompra;
import edu.bodega.yessy.back_sol.models.Empleado;
import edu.bodega.yessy.back_sol.models.EstadoOrdenCompra;
import edu.bodega.yessy.back_sol.models.MetodoPago;
import edu.bodega.yessy.back_sol.models.OrdenCompra;
import edu.bodega.yessy.back_sol.models.Producto;
import edu.bodega.yessy.back_sol.models.Proveedor;
import edu.bodega.yessy.back_sol.repositories.EmpleadoRepository;
import edu.bodega.yessy.back_sol.repositories.MetodoPagoRepository;
import edu.bodega.yessy.back_sol.repositories.OrdenCompraRepository;
import edu.bodega.yessy.back_sol.repositories.ProductoRepository;
import edu.bodega.yessy.back_sol.repositories.ProveedorRepository;

@Service
public class OrdenCompraService {

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private MetodoPagoRepository metodoDePagoRepository;

    @Autowired
    private EstadoOrdenCompraService estadoOrdenCompraService;

    private static final BigDecimal IGV = new BigDecimal("0.18");

    // ================= LISTAR =================
    public ArrayList<OrdenCompraResponse> listar() {

        ArrayList<OrdenCompraResponse> lista = new ArrayList<>();

        for (OrdenCompra o : ordenCompraRepository.findAll()) {
            lista.add(convertirDTO(o));
        }

        return lista;
    }

    // ================= BUSCAR =================
    public OrdenCompraResponse buscar(Integer id) {

        OrdenCompra o = ordenCompraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Orden de compra no encontrada"));

        return convertirDTO(o);
    }

    // ================= LISTAR POR EMPLEADO =================
    public ArrayList<OrdenCompraResponse> listarPorEmpleado(Integer idEmpleado) {

        ArrayList<OrdenCompraResponse> lista = new ArrayList<>();

        for (OrdenCompra o : ordenCompraRepository.findByEmpleado_Idempleado(idEmpleado)) {
            lista.add(convertirDTO(o));
        }

        return lista;
    }

    // ================= LISTAR POR PROVEEDOR =================
    public ArrayList<OrdenCompraResponse> listarPorProveedor(Integer idProveedor) {

        ArrayList<OrdenCompraResponse> lista = new ArrayList<>();

        for (OrdenCompra o : ordenCompraRepository.findByProveedor_IdProveedor(idProveedor)) {
            lista.add(convertirDTO(o));
        }

        return lista;
    }

    // ================= LISTAR POR ESTADO =================
    public ArrayList<OrdenCompraResponse> listarPorEstado(Integer idEstado) {

        ArrayList<OrdenCompraResponse> lista = new ArrayList<>();

        for (OrdenCompra o : ordenCompraRepository.findByEstadoOc_IdestadoOc(idEstado)) {
            lista.add(convertirDTO(o));
        }

        return lista;
    }

    // ================= CREAR =================
    public OrdenCompraResponse nuevo(OrdenCompraRequest dto) {

        Empleado empleado = empleadoRepository.findById(dto.getIdEmpleado())
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        Proveedor proveedor = proveedorRepository.findById(dto.getIdProveedor())
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        MetodoPago metodo = metodoDePagoRepository.findById(dto.getIdMetodoPago())
                .orElseThrow(() -> new RuntimeException("Método de pago no encontrado"));

        EstadoOrdenCompra estado = estadoOrdenCompraService.buscarPorNombre("Pendiente");

        // Calcular totales
        BigDecimal subtotal = BigDecimal.ZERO;
        for (DetalleOrdenCompraRequest d : dto.getDetalles()) {
            subtotal = subtotal.add(
                d.getPrecioUnitario().multiply(new BigDecimal(d.getCantidadSolicitada()))
            );
        }
        subtotal = subtotal.setScale(2, RoundingMode.HALF_UP);
        BigDecimal igv   = subtotal.multiply(IGV).setScale(2, RoundingMode.HALF_UP);
        BigDecimal total = subtotal.add(igv);

        OrdenCompra orden = new OrdenCompra();
        orden.setEmpleado(empleado);
        orden.setProveedor(proveedor);
        orden.setMetodoDePago(metodo);
        orden.setEstadoOc(estado);
        orden.setNumeroOrden(generarNumeroOrden());
        orden.setFechaEmision(dto.getFechaEmision());
        orden.setFechaEntregaEsperada(dto.getFechaEntregaEsperada());
        orden.setCondicionesPago(dto.getCondicionesPago());
        orden.setMoneda(dto.getMoneda() != null ? dto.getMoneda() : "PEN");
        orden.setSubtotal(subtotal);
        orden.setIgv(igv);
        orden.setTotal(total);
        orden.setObservaciones(dto.getObservaciones());
        orden.setFechaRegistro(LocalDateTime.now());

        // Mapear detalles
        List<DetalleOrdenCompra> detalles = new ArrayList<>();
        for (DetalleOrdenCompraRequest d : dto.getDetalles()) {
            detalles.add(mapearDetalle(d, orden));
        }
        orden.setDetalles(detalles);

        return convertirDTO(ordenCompraRepository.save(orden));
    }

    // ================= CAMBIAR ESTADO =================
    public OrdenCompraResponse cambiarEstado(Integer id, Integer idNuevoEstado) {

        OrdenCompra orden = ordenCompraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Orden de compra no encontrada"));

        if ("Anulada".equals(orden.getEstadoOc().getNombre())) {
            throw new RuntimeException("No se puede cambiar el estado de una orden anulada");
        }

        EstadoOrdenCompra nuevoEstado = estadoOrdenCompraService.buscarEntidad(idNuevoEstado);


        orden.setEstadoOc(nuevoEstado);

        return convertirDTO(ordenCompraRepository.save(orden));
    }

    // ================= ANULAR =================
    public void anular(Integer id) {

        OrdenCompra orden = ordenCompraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Orden de compra no encontrada"));

        if ("Recibida".equals(orden.getEstadoOc().getNombre())) {
            throw new RuntimeException("No se puede anular una orden ya recibida");
        }

        EstadoOrdenCompra estadoAnulada = estadoOrdenCompraService.buscarPorNombre("Anulada");

        orden.setEstadoOc(estadoAnulada);
        ordenCompraRepository.save(orden);
    }

    // ================= HELPERS PRIVADOS =================
    private String generarNumeroOrden() {
        String anio = String.valueOf(LocalDate.now().getYear());
        long correlativo = ordenCompraRepository.count() + 1;
        return "OC-" + anio + "-" + String.format("%04d", correlativo);
    }

    private DetalleOrdenCompra mapearDetalle(DetalleOrdenCompraRequest dto, OrdenCompra orden) {

        Producto producto = productoRepository.findById(dto.getIdProducto())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + dto.getIdProducto()));

        BigDecimal subTotal = dto.getPrecioUnitario()
                .multiply(new BigDecimal(dto.getCantidadSolicitada()))
                .setScale(2, RoundingMode.HALF_UP);

        DetalleOrdenCompra detalle = new DetalleOrdenCompra();
        detalle.setOrdenCompra(orden);
        detalle.setProducto(producto);
        detalle.setCantidadSolicitada(dto.getCantidadSolicitada());
        detalle.setPrecioUnitario(dto.getPrecioUnitario());
        detalle.setSubTotal(subTotal);
        detalle.setFechaVencimientoEsperada(dto.getFechaVencimientoEsperada());
        detalle.setLoteEsperado(dto.getLoteEsperado());
        detalle.setObservaciones(dto.getObservaciones());

        return detalle;
    }

    // ================= MAPPER =================
    private OrdenCompraResponse convertirDTO(OrdenCompra o) {

        OrdenCompraResponse dto = new OrdenCompraResponse();

        dto.setIdordenCompra(o.getIdordenCompra());
        dto.setNumeroOrden(o.getNumeroOrden());
        dto.setIdEmpleado(o.getEmpleado().getIdempleado());
        dto.setNombreEmpleado(
            o.getEmpleado().getPersona().getNombre()
            + " " + o.getEmpleado().getPersona().getApellido()
        );
        dto.setIdProveedor(o.getProveedor().getIdProveedor());
        dto.setNombreProveedor(o.getProveedor().getPersona().getNombre());
        dto.setIdEstadoOc(o.getEstadoOc().getIdestadoOc());
        dto.setEstadoOc(o.getEstadoOc().getNombre());
        dto.setIdMetodoPago(o.getMetodoDePago().getIdmetododepago());
        dto.setMetodoPago(o.getMetodoDePago().getNombre());
        dto.setCondicionesPago(o.getCondicionesPago());
        dto.setMoneda(o.getMoneda());
        dto.setFechaEmision(o.getFechaEmision());
        dto.setFechaEntregaEsperada(o.getFechaEntregaEsperada());
        dto.setSubtotal(o.getSubtotal());
        dto.setIgv(o.getIgv());
        dto.setTotal(o.getTotal());
        dto.setObservaciones(o.getObservaciones());
        dto.setFechaRegistro(o.getFechaRegistro());

        ArrayList<DetalleOrdenCompraResponse> detallesDTO = new ArrayList<>();
        for (DetalleOrdenCompra d : o.getDetalles()) {
            DetalleOrdenCompraResponse dd = new DetalleOrdenCompraResponse();
            dd.setIddetalleOc(d.getIddetalleOc());
            dd.setIdProducto(d.getProducto().getIdproducto());
            dd.setNombreProducto(d.getProducto().getNombre());
            dd.setCantidadSolicitada(d.getCantidadSolicitada());
            dd.setPrecioUnitario(d.getPrecioUnitario());
            dd.setSubTotal(d.getSubTotal());
            dd.setFechaVencimientoEsperada(d.getFechaVencimientoEsperada());
            dd.setLoteEsperado(d.getLoteEsperado());
            dd.setObservaciones(d.getObservaciones());
            detallesDTO.add(dd);
        }
        dto.setDetalles(detallesDTO);

        return dto;
    }
}
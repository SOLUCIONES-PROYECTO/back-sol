package edu.bodega.yessy.back_sol.dto.ordencompra;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import edu.bodega.yessy.back_sol.dto.detalleordencompra.DetalleOrdenCompraResponse;

public class OrdenCompraResponse {

    private Integer idordenCompra;
    private String numeroOrden;
    private Integer idEmpleado;
    private String nombreEmpleado;
    private Integer idProveedor;
    private String nombreProveedor;
    private Integer idEstadoOc;
    private String estadoOc;
    private Integer idMetodoPago;
    private String metodoPago;
    private String condicionesPago;
    private String moneda;
    private LocalDate fechaEmision;
    private LocalDate fechaEntregaEsperada;
    private BigDecimal subtotal;
    private BigDecimal igv;
    private BigDecimal total;
    private String observaciones;
    private LocalDateTime fechaRegistro;
    private List<DetalleOrdenCompraResponse> detalles;

    public Integer getIdordenCompra() { return idordenCompra; }
    public void setIdordenCompra(Integer idordenCompra) { this.idordenCompra = idordenCompra; }

    public String getNumeroOrden() { return numeroOrden; }
    public void setNumeroOrden(String numeroOrden) { this.numeroOrden = numeroOrden; }

    public Integer getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(Integer idEmpleado) { this.idEmpleado = idEmpleado; }

    public String getNombreEmpleado() { return nombreEmpleado; }
    public void setNombreEmpleado(String nombreEmpleado) { this.nombreEmpleado = nombreEmpleado; }

    public Integer getIdProveedor() { return idProveedor; }
    public void setIdProveedor(Integer idProveedor) { this.idProveedor = idProveedor; }

    public String getNombreProveedor() { return nombreProveedor; }
    public void setNombreProveedor(String nombreProveedor) { this.nombreProveedor = nombreProveedor; }

    public Integer getIdEstadoOc() { return idEstadoOc; }
    public void setIdEstadoOc(Integer idEstadoOc) { this.idEstadoOc = idEstadoOc; }

    public String getEstadoOc() { return estadoOc; }
    public void setEstadoOc(String estadoOc) { this.estadoOc = estadoOc; }

    public Integer getIdMetodoPago() { return idMetodoPago; }
    public void setIdMetodoPago(Integer idMetodoPago) { this.idMetodoPago = idMetodoPago; }

    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }

    public String getCondicionesPago() { return condicionesPago; }
    public void setCondicionesPago(String condicionesPago) { this.condicionesPago = condicionesPago; }

    public String getMoneda() { return moneda; }
    public void setMoneda(String moneda) { this.moneda = moneda; }

    public LocalDate getFechaEmision() { return fechaEmision; }
    public void setFechaEmision(LocalDate fechaEmision) { this.fechaEmision = fechaEmision; }

    public LocalDate getFechaEntregaEsperada() { return fechaEntregaEsperada; }
    public void setFechaEntregaEsperada(LocalDate fechaEntregaEsperada) { this.fechaEntregaEsperada = fechaEntregaEsperada; }

    public BigDecimal getSubtotal() { return subtotal; }
    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }

    public BigDecimal getIgv() { return igv; }
    public void setIgv(BigDecimal igv) { this.igv = igv; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }

    public List<DetalleOrdenCompraResponse> getDetalles() { return detalles; }
    public void setDetalles(List<DetalleOrdenCompraResponse> detalles) { this.detalles = detalles; }
}
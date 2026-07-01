package edu.bodega.yessy.back_sol.dto.ordencompra;

import java.time.LocalDate;
import java.util.List;

import edu.bodega.yessy.back_sol.dto.detalleordencompra.DetalleOrdenCompraRequest;

public class OrdenCompraRequest {

    private Integer idEmpleado;
    private Integer idProveedor;
    private Integer idMetodoPago;
    private String condicionesPago;
    private String moneda;
    private LocalDate fechaEmision;
    private LocalDate fechaEntregaEsperada;
    private String observaciones;
    private List<DetalleOrdenCompraRequest> detalles;

    public Integer getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(Integer idEmpleado) { this.idEmpleado = idEmpleado; }

    public Integer getIdProveedor() { return idProveedor; }
    public void setIdProveedor(Integer idProveedor) { this.idProveedor = idProveedor; }

    public Integer getIdMetodoPago() { return idMetodoPago; }
    public void setIdMetodoPago(Integer idMetodoPago) { this.idMetodoPago = idMetodoPago; }

    public String getCondicionesPago() { return condicionesPago; }
    public void setCondicionesPago(String condicionesPago) { this.condicionesPago = condicionesPago; }

    public String getMoneda() { return moneda; }
    public void setMoneda(String moneda) { this.moneda = moneda; }

    public LocalDate getFechaEmision() { return fechaEmision; }
    public void setFechaEmision(LocalDate fechaEmision) { this.fechaEmision = fechaEmision; }

    public LocalDate getFechaEntregaEsperada() { return fechaEntregaEsperada; }
    public void setFechaEntregaEsperada(LocalDate fechaEntregaEsperada) { this.fechaEntregaEsperada = fechaEntregaEsperada; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    public List<DetalleOrdenCompraRequest> getDetalles() { return detalles; }
    public void setDetalles(List<DetalleOrdenCompraRequest> detalles) { this.detalles = detalles; }
}
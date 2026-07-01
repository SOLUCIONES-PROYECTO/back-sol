package edu.bodega.yessy.back_sol.dto.detalleordencompra;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DetalleOrdenCompraRequest {

    private Integer idProducto;
    private Integer cantidadSolicitada;
    private BigDecimal precioUnitario;
    private LocalDate fechaVencimientoEsperada;
    private String loteEsperado;
    private String observaciones;

    public Integer getIdProducto() { return idProducto; }
    public void setIdProducto(Integer idProducto) { this.idProducto = idProducto; }

    public Integer getCantidadSolicitada() { return cantidadSolicitada; }
    public void setCantidadSolicitada(Integer cantidadSolicitada) { this.cantidadSolicitada = cantidadSolicitada; }

    public BigDecimal getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(BigDecimal precioUnitario) { this.precioUnitario = precioUnitario; }

    public LocalDate getFechaVencimientoEsperada() { return fechaVencimientoEsperada; }
    public void setFechaVencimientoEsperada(LocalDate fechaVencimientoEsperada) { this.fechaVencimientoEsperada = fechaVencimientoEsperada; }

    public String getLoteEsperado() { return loteEsperado; }
    public void setLoteEsperado(String loteEsperado) { this.loteEsperado = loteEsperado; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
}
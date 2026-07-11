package edu.bodega.yessy.back_sol.dto.detalleordencompra;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DetalleOrdenCompraResponse {

    private Integer iddetalleOc;
    private Integer idProducto;
    private String nombreProducto;
    private Integer cantidadSolicitada;
    private BigDecimal precioUnitario;
    private BigDecimal subTotal;
    private LocalDate fechaVencimientoEsperada;
    private String loteEsperado;
    private String observaciones;

    public Integer getIddetalleOc() { return iddetalleOc; }
    public void setIddetalleOc(Integer iddetalleOc) { this.iddetalleOc = iddetalleOc; }

    public Integer getIdProducto() { return idProducto; }
    public void setIdProducto(Integer idProducto) { this.idProducto = idProducto; }

    public String getNombreProducto() { return nombreProducto; }
    public void setNombreProducto(String nombreProducto) { this.nombreProducto = nombreProducto; }

    public Integer getCantidadSolicitada() { return cantidadSolicitada; }
    public void setCantidadSolicitada(Integer cantidadSolicitada) { this.cantidadSolicitada = cantidadSolicitada; }

    public BigDecimal getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(BigDecimal precioUnitario) { this.precioUnitario = precioUnitario; }

    public BigDecimal getSubTotal() { return subTotal; }
    public void setSubTotal(BigDecimal subTotal) { this.subTotal = subTotal; }

    public LocalDate getFechaVencimientoEsperada() { return fechaVencimientoEsperada; }
    public void setFechaVencimientoEsperada(LocalDate fechaVencimientoEsperada) { this.fechaVencimientoEsperada = fechaVencimientoEsperada; }

    public String getLoteEsperado() { return loteEsperado; }
    public void setLoteEsperado(String loteEsperado) { this.loteEsperado = loteEsperado; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
}
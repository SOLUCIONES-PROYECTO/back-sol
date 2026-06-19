package edu.bodega.yessy.back_sol.dto.detalleentrada;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DetalleEntradaResponseDTO {

    private Integer idDetalleEntrada;

    private Integer idDocEntrada;
    private String numeroDocumento;

    private Integer idProducto;
    private String nombreProducto;

    private Integer cantidad;
    private BigDecimal subtotal;

    private String loteProducto;
    private LocalDate fechaVencimiento;

    private BigDecimal precioUnitario;

    public Integer getIdDetalleEntrada() {
        return idDetalleEntrada;
    }

    public void setIdDetalleEntrada(Integer idDetalleEntrada) {
        this.idDetalleEntrada = idDetalleEntrada;
    }

    public Integer getIdDocEntrada() {
        return idDocEntrada;
    }

    public void setIdDocEntrada(Integer idDocEntrada) {
        this.idDocEntrada = idDocEntrada;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public String getLoteProducto() {
        return loteProducto;
    }

    public void setLoteProducto(String loteProducto) {
        this.loteProducto = loteProducto;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}

package edu.bodega.yessy.back_sol.dto.detallesalida;

import java.math.BigDecimal;

public class DetalleSalidaResponseDTO {

    private Integer idDetalleSalida;

    // Producto
    private Integer idProducto;
    private String nombreProducto;

    // Documento de salida
    private Integer idDocSalida;
    private String numeroDocumentoSalida;

    // Datos del movimiento
    private Integer cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal subtotal;
    public Integer getIdDetalleSalida() {
        return idDetalleSalida;
    }
    public void setIdDetalleSalida(Integer idDetalleSalida) {
        this.idDetalleSalida = idDetalleSalida;
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
    public Integer getIdDocSalida() {
        return idDocSalida;
    }
    public void setIdDocSalida(Integer idDocSalida) {
        this.idDocSalida = idDocSalida;
    }
    public String getNumeroDocumentoSalida() {
        return numeroDocumentoSalida;
    }
    public void setNumeroDocumentoSalida(String numeroDocumentoSalida) {
        this.numeroDocumentoSalida = numeroDocumentoSalida;
    }
    public Integer getCantidad() {
        return cantidad;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }
    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    public BigDecimal getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}

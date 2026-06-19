package edu.bodega.yessy.back_sol.dto.detallesalida;

import java.math.BigDecimal;

public class DetalleSalidaRequestDTO {

    private Integer idProducto;

    private Integer cantidad;

    private BigDecimal precioUnitario;
    private BigDecimal subtotal;

    private Integer idDocSalida;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
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

    public Integer getIdDocSalida() {
        return idDocSalida;
    }

    public void setIdDocSalida(Integer idDocSalida) {
        this.idDocSalida = idDocSalida;
    }
}

package edu.bodega.yessy.back_sol.models;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "detallesalida")
public class DetalleSalida {

    @Id
    private Integer iddetalleSalida;

    private Integer producto_idproducto;
    private Integer cantidad;

    private BigDecimal precioUnitario;
    private BigDecimal subtotal;

    private Integer docsalida_iddocsalida;

    public Integer getIddetalleSalida() {
        return iddetalleSalida;
    }

    public void setIddetalleSalida(Integer iddetalleSalida) {
        this.iddetalleSalida = iddetalleSalida;
    }

    public Integer getProducto_idproducto() {
        return producto_idproducto;
    }

    public void setProducto_idproducto(Integer producto_idproducto) {
        this.producto_idproducto = producto_idproducto;
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

    public Integer getDocsalida_iddocsalida() {
        return docsalida_iddocsalida;
    }

    public void setDocsalida_iddocsalida(Integer docsalida_iddocsalida) {
        this.docsalida_iddocsalida = docsalida_iddocsalida;
    }

    
}

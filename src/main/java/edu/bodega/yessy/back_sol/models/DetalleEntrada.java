package edu.bodega.yessy.back_sol.models;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "detalleentrada")
public class DetalleEntrada {

    @Id
    private Integer iddetalleEntrada;

    private Integer docentrada_iddocentrada;
    private Integer producto_idproducto;
    private Integer cantidad;

    private BigDecimal subtotal;
    private String loteproducto;

    @Temporal(TemporalType.DATE)
    private Date fechavencimiento;

    private BigDecimal preciounitario;

    public Integer getIddetalleEntrada() {
        return iddetalleEntrada;
    }

    public void setIddetalleEntrada(Integer iddetalleEntrada) {
        this.iddetalleEntrada = iddetalleEntrada;
    }

    public Integer getDocentrada_iddocentrada() {
        return docentrada_iddocentrada;
    }

    public void setDocentrada_iddocentrada(Integer docentrada_iddocentrada) {
        this.docentrada_iddocentrada = docentrada_iddocentrada;
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

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public String getLoteproducto() {
        return loteproducto;
    }

    public void setLoteproducto(String loteproducto) {
        this.loteproducto = loteproducto;
    }

    public Date getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(Date fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public BigDecimal getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(BigDecimal preciounitario) {
        this.preciounitario = preciounitario;
    }

    
}

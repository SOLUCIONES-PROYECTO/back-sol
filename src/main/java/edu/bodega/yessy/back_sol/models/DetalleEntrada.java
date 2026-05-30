package edu.bodega.yessy.back_sol.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalleentrada")
public class DetalleEntrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddetalleEntrada")
    private Integer iddetalleEntrada;

    @Column(name = "docentrada_iddocentrada")
    private Integer docentrada_iddocentrada;

    @Column(name = "producto_idproducto")
    private Integer producto_idproducto;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "subtotal")
    private BigDecimal subtotal;

    @Column(name = "loteproducto")
    private String loteproducto;

    @Column(name = "fechavencimiento")
    private LocalDate fechavencimiento;

    @Column(name = "preciounitario")
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

    public LocalDate getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(LocalDate fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public BigDecimal getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(BigDecimal preciounitario) {
        this.preciounitario = preciounitario;
    }
}
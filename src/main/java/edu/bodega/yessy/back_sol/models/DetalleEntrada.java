package edu.bodega.yessy.back_sol.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_entrada")
public class DetalleEntrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddetalleEntrada;

    @ManyToOne
    @JoinColumn(name="id_doc_entrada", nullable = false)
    private DocEntrada docEntrada;

    @ManyToOne
    @JoinColumn(name="id_producto", nullable = false)
    private Producto producto;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "sub_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal subtotal;

    @Column(name = "lote_producto", nullable = false)
    private String loteproducto;

    @Column(name = "fecha_vencimiento", nullable = false)
    private LocalDate fechavencimiento;

    @Column(name = "precio_unitario", nullable = false, precision = 10, scale = 2)
    private BigDecimal preciounitario;

    public Integer getIddetalleEntrada() {
        return iddetalleEntrada;
    }

    public void setIddetalleEntrada(Integer iddetalleEntrada) {
        this.iddetalleEntrada = iddetalleEntrada;
    }

    public DocEntrada getDocEntrada() {
        return docEntrada;
    }

    public void setDocEntrada(DocEntrada docEntrada) {
        this.docEntrada = docEntrada;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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
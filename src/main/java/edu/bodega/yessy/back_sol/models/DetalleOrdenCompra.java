package edu.bodega.yessy.back_sol.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_orden_compra")
public class DetalleOrdenCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddetalleOc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idorden_compra", nullable = false)
    private OrdenCompra ordenCompra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    @Column(name = "cantidad_solicitada", nullable = false)
    private Integer cantidadSolicitada;

    @Column(name = "precio_unitario", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioUnitario;

    @Column(name = "sub_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal subTotal;

    @Column(name = "fecha_vencimiento_esperada")
    private LocalDate fechaVencimientoEsperada;

    @Column(name = "lote_esperado")
    private String loteEsperado;

    @Column(name = "observaciones")
    private String observaciones;

    public Integer getIddetalleOc() { return iddetalleOc; }
    public void setIddetalleOc(Integer iddetalleOc) { this.iddetalleOc = iddetalleOc; }

    public OrdenCompra getOrdenCompra() { return ordenCompra; }
    public void setOrdenCompra(OrdenCompra ordenCompra) { this.ordenCompra = ordenCompra; }

    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }

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
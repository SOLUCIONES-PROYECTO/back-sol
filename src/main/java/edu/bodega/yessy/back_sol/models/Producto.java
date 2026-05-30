package edu.bodega.yessy.back_sol.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idproducto;
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @Column
    private String categoria;
    @Column (name = "`proveedor_idProveedor`")
    private Integer proveedor_idProveedor;
    @Column(name = "`precioCompra`")
    private BigDecimal precioCompra;
    @Column(name = "`precioVenta`")
    private BigDecimal precioVenta;
    @Column(name = "`stockMinimo`")
    private Integer stockMinimo;
    @Column(name = "`stockActual`")
    private Integer stockActual;
    @Column
    private String imagen;
    @Column(name = "`margen`")
    private BigDecimal margen;
    @Column(name = "`ganancia`")
    private BigDecimal ganancia;
    @Column (name = "`estadoProducto_idEstadoProducto`")
    private Integer estadoProducto_idEstadoProducto;
    @Column (name = "`unidadMedida_idUnidadMedida`")
    private Integer unidadMedida_idUnidadMedida;

    

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public BigDecimal getPrecioCompra() {
        return precioCompra;
    }
    public void setPrecioCompra(BigDecimal precioCompra) {
        this.precioCompra = precioCompra;
    }
    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }
    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }
    public Integer getStockMinimo() {
        return stockMinimo;
    }
    public void setStockMinimo(Integer stockMinimo) {
        this.stockMinimo = stockMinimo;
    }
    public Integer getStockActual() {
        return stockActual;
    }
    public void setStockActual(Integer stockActual) {
        this.stockActual = stockActual;
    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public BigDecimal getMargen() {
        return margen;
    }
    public void setMargen(BigDecimal margen) {
        this.margen = margen;
    }
    public BigDecimal getGanancia() {
        return ganancia;
    }
    public void setGanancia(BigDecimal ganancia) {
        this.ganancia = ganancia;
    }
    public Integer getProveedor_idProveedor() {
        return proveedor_idProveedor;
    }
    public void setProveedor_idProveedor(Integer proveedor_idProveedor) {
        this.proveedor_idProveedor = proveedor_idProveedor;
    }
    public Integer getEstadoProducto_idEstadoProducto() {
        return estadoProducto_idEstadoProducto;
    }
    public void setEstadoProducto_idEstadoProducto(Integer estadoProducto_idEstadoProducto) {
        this.estadoProducto_idEstadoProducto = estadoProducto_idEstadoProducto;
    }
    public Integer getUnidadMedida_idUnidadMedida() {
        return unidadMedida_idUnidadMedida;
    }
    public void setUnidadMedida_idUnidadMedida(Integer unidadMedida_idUnidadMedida) {
        this.unidadMedida_idUnidadMedida = unidadMedida_idUnidadMedida;
    }
}

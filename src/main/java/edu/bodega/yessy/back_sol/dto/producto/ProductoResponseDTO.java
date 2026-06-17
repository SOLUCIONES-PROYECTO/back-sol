package edu.bodega.yessy.back_sol.dto.producto;

import java.math.BigDecimal;

public class ProductoResponseDTO {
    private Integer idproducto;
    private String nombre;
    private String descripcion;
    private String categoria;
    private String proveedor;
    private BigDecimal precioCompra;
    private BigDecimal precioVenta;
    private Integer stockActual;
    private Integer stockMinimo;
    private String estado;
    private String unidadMedida;
    private String imagen;
    private BigDecimal margen;
    private BigDecimal ganancia;

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

public String getProveedor() {
    return proveedor;
}

public void setProveedor(String proveedor) {
    this.proveedor = proveedor;
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

public Integer getStockActual() {
    return stockActual;
}

public void setStockActual(Integer stockActual) {
    this.stockActual = stockActual;
}

public Integer getStockMinimo() {
    return stockMinimo;
}

public void setStockMinimo(Integer stockMinimo) {
    this.stockMinimo = stockMinimo;
}

public String getEstado() {
    return estado;
}

public void setEstado(String estado) {
    this.estado = estado;
}

public String getUnidadMedida() {
    return unidadMedida;
}

public void setUnidadMedida(String unidadMedida) {
    this.unidadMedida = unidadMedida;
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

    

    
}

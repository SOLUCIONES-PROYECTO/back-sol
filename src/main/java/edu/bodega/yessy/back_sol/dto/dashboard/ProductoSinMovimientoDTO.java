package edu.bodega.yessy.back_sol.dto.dashboard;

import java.time.LocalDate;

public class ProductoSinMovimientoDTO {

    private Integer idProducto;
    private String nombreProducto;
    private Integer stockActual;
    private Integer stockMinimo;
    private LocalDate fechaUltimaVenta; // null si nunca se vendió

    public ProductoSinMovimientoDTO(Integer idProducto, String nombreProducto, Integer stockActual, Integer stockMinimo, LocalDate fechaUltimaVenta) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
        this.fechaUltimaVenta = fechaUltimaVenta;
    }

    public Integer getIdProducto() { return idProducto; }
    public void setIdProducto(Integer idProducto) { this.idProducto = idProducto; }

    public String getNombreProducto() { return nombreProducto; }
    public void setNombreProducto(String nombreProducto) { this.nombreProducto = nombreProducto; }

    public Integer getStockActual() { return stockActual; }
    public void setStockActual(Integer stockActual) { this.stockActual = stockActual; }

    public Integer getStockMinimo() { return stockMinimo; }
    public void setStockMinimo(Integer stockMinimo) { this.stockMinimo = stockMinimo; }

    public LocalDate getFechaUltimaVenta() { return fechaUltimaVenta; }
    public void setFechaUltimaVenta(LocalDate fechaUltimaVenta) { this.fechaUltimaVenta = fechaUltimaVenta; }
}
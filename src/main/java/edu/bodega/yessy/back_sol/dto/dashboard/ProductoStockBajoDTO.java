package edu.bodega.yessy.back_sol.dto.dashboard;

public class ProductoStockBajoDTO {

    private Integer idProducto;
    private String nombreProducto;
    private Integer stockActual;
    private Integer stockMinimo;

    public ProductoStockBajoDTO(Integer idProducto, String nombreProducto, Integer stockActual, Integer stockMinimo) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
    }

    public Integer getIdProducto() { return idProducto; }
    public void setIdProducto(Integer idProducto) { this.idProducto = idProducto; }

    public String getNombreProducto() { return nombreProducto; }
    public void setNombreProducto(String nombreProducto) { this.nombreProducto = nombreProducto; }

    public Integer getStockActual() { return stockActual; }
    public void setStockActual(Integer stockActual) { this.stockActual = stockActual; }

    public Integer getStockMinimo() { return stockMinimo; }
    public void setStockMinimo(Integer stockMinimo) { this.stockMinimo = stockMinimo; }
}
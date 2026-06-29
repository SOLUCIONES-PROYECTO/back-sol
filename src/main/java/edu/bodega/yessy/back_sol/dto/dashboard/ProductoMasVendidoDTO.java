package edu.bodega.yessy.back_sol.dto.dashboard;

public class ProductoMasVendidoDTO {
    private Integer idProducto;
    private String nombreProducto;
    private Long cantidadVendida;

    public ProductoMasVendidoDTO(Integer idProducto, String nombreProducto, Long cantidadVendida) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.cantidadVendida = cantidadVendida;
    }

    public Integer getIdProducto() { return idProducto; }
    public void setIdProducto(Integer idProducto) { this.idProducto = idProducto; }

    public String getNombreProducto() { return nombreProducto; }
    public void setNombreProducto(String nombreProducto) { this.nombreProducto = nombreProducto; }

    public Long getCantidadVendida() { return cantidadVendida; }
    public void setCantidadVendida(Long cantidadVendida) { this.cantidadVendida = cantidadVendida; }
}

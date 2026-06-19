package edu.bodega.yessy.back_sol.dto.estadoproducto;

public class EstadoProductoResponseDTO {

    private Integer idEstadoProducto;
    private String nombre;
    public Integer getIdEstadoProducto() {
        return idEstadoProducto;
    }
    public void setIdEstadoProducto(Integer idEstadoProducto) {
        this.idEstadoProducto = idEstadoProducto;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

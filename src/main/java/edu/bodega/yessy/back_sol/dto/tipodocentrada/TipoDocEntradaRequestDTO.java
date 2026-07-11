package edu.bodega.yessy.back_sol.dto.tipodocentrada;

public class TipoDocEntradaRequestDTO {

    private String nombre;
    private String descripcion;
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
}

package edu.bodega.yessy.back_sol.dto.tipodocentrada;

public class TipoDocEntradaResponseDTO {

    private Integer idTipoDocEntrada;
    private String nombre;
    private String descripcion;
    public Integer getIdTipoDocEntrada() {
        return idTipoDocEntrada;
    }
    public void setIdTipoDocEntrada(Integer idTipoDocEntrada) {
        this.idTipoDocEntrada = idTipoDocEntrada;
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
}

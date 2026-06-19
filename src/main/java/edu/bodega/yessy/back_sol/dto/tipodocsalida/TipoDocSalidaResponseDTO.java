package edu.bodega.yessy.back_sol.dto.tipodocsalida;

public class TipoDocSalidaResponseDTO {

    private Integer idTipoDocSalida;
    private String nombre;
    private String descripcion;
    public Integer getIdTipoDocSalida() {
        return idTipoDocSalida;
    }
    public void setIdTipoDocSalida(Integer idTipoDocSalida) {
        this.idTipoDocSalida = idTipoDocSalida;
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

package edu.bodega.yessy.back_sol.dto.estadoingreso;

public class EstadoIngresoResponseDTO {

    private Integer idEstadoIngreso;
    private String nombre;
    public Integer getIdEstadoIngreso() {
        return idEstadoIngreso;
    }
    public void setIdEstadoIngreso(Integer idEstadoIngreso) {
        this.idEstadoIngreso = idEstadoIngreso;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

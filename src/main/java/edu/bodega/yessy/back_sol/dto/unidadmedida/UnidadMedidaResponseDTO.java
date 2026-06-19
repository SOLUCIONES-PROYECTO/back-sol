package edu.bodega.yessy.back_sol.dto.unidadmedida;

public class UnidadMedidaResponseDTO {

    private Integer idUnidadMedida;
    private String nombre;
    public Integer getIdUnidadMedida() {
        return idUnidadMedida;
    }
    public void setIdUnidadMedida(Integer idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
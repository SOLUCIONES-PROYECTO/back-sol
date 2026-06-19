package edu.bodega.yessy.back_sol.dto.detalleusointerno;

public class DetalleUsoInternoRequestDTO {

    private String descripcion;

    private Integer idDetalleSalida;
    private Integer idAreaUsoInterno;
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Integer getIdDetalleSalida() {
        return idDetalleSalida;
    }
    public void setIdDetalleSalida(Integer idDetalleSalida) {
        this.idDetalleSalida = idDetalleSalida;
    }
    public Integer getIdAreaUsoInterno() {
        return idAreaUsoInterno;
    }
    public void setIdAreaUsoInterno(Integer idAreaUsoInterno) {
        this.idAreaUsoInterno = idAreaUsoInterno;
    }
}

package edu.bodega.yessy.back_sol.dto.detallemerma;

public class DetalleMermaRequestDTO {

    private Integer idDetalleSalida;
    private String motivoMerma;
    private String descripcion;
    public Integer getIdDetalleSalida() {
        return idDetalleSalida;
    }
    public void setIdDetalleSalida(Integer idDetalleSalida) {
        this.idDetalleSalida = idDetalleSalida;
    }
    public String getMotivoMerma() {
        return motivoMerma;
    }
    public void setMotivoMerma(String motivoMerma) {
        this.motivoMerma = motivoMerma;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

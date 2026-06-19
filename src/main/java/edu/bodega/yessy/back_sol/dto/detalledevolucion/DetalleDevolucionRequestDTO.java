package edu.bodega.yessy.back_sol.dto.detalledevolucion;

public class DetalleDevolucionRequestDTO {

    private Integer idDetalleSalida;

    private String motivo;

    public Integer getIdDetalleSalida() {
        return idDetalleSalida;
    }

    public void setIdDetalleSalida(Integer idDetalleSalida) {
        this.idDetalleSalida = idDetalleSalida;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}

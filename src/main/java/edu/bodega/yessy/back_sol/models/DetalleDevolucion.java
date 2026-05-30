package edu.bodega.yessy.back_sol.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalledevolucion")
public class DetalleDevolucion {

    @Id
    private Integer iddetalleDevolucion;

    private Integer detalleSalida_iddetalleSalida;
    private String motivo;
    public Integer getIddetalleDevolucion() {
        return iddetalleDevolucion;
    }
    public void setIddetalleDevolucion(Integer iddetalleDevolucion) {
        this.iddetalleDevolucion = iddetalleDevolucion;
    }
    public Integer getDetalleSalida_iddetalleSalida() {
        return detalleSalida_iddetalleSalida;
    }
    public void setDetalleSalida_iddetalleSalida(Integer detalleSalida_iddetalleSalida) {
        this.detalleSalida_iddetalleSalida = detalleSalida_iddetalleSalida;
    }
    public String getMotivo() {
        return motivo;
    }
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    
}

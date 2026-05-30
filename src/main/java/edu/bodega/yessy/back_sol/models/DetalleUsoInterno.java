package edu.bodega.yessy.back_sol.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalleusointerno")
public class DetalleUsoInterno {

    @Id
    private Integer iddetalleusoInterno;

    private String descripcion;

    private Integer detalleSalida_iddetalleSalida;
    private Integer areausoInterno_idareausoInterno;
    public Integer getIddetalleusoInterno() {
        return iddetalleusoInterno;
    }
    public void setIddetalleusoInterno(Integer iddetalleusoInterno) {
        this.iddetalleusoInterno = iddetalleusoInterno;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Integer getDetalleSalida_iddetalleSalida() {
        return detalleSalida_iddetalleSalida;
    }
    public void setDetalleSalida_iddetalleSalida(Integer detalleSalida_iddetalleSalida) {
        this.detalleSalida_iddetalleSalida = detalleSalida_iddetalleSalida;
    }
    public Integer getAreausoInterno_idareausoInterno() {
        return areausoInterno_idareausoInterno;
    }
    public void setAreausoInterno_idareausoInterno(Integer areausoInterno_idareausoInterno) {
        this.areausoInterno_idareausoInterno = areausoInterno_idareausoInterno;
    }

    
}

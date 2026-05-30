package edu.bodega.yessy.back_sol.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "detallemerma")
public class DetalleMerma {

    @Id
    private Integer iddetalleMerma;

    private Integer detalleSalida_iddetalleSalida;

    private String motivoMerma;
    private String descripcion;
    public Integer getIddetalleMerma() {
        return iddetalleMerma;
    }
    public void setIddetalleMerma(Integer iddetalleMerma) {
        this.iddetalleMerma = iddetalleMerma;
    }
    public Integer getDetalleSalida_iddetalleSalida() {
        return detalleSalida_iddetalleSalida;
    }
    public void setDetalleSalida_iddetalleSalida(Integer detalleSalida_iddetalleSalida) {
        this.detalleSalida_iddetalleSalida = detalleSalida_iddetalleSalida;
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

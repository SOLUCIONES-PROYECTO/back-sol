package edu.bodega.yessy.back_sol.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "detallemerma")
public class DetalleMerma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddetalleMerma")
    private Integer iddetalleMerma;

    @Column(name = "detalleSalida_iddetalleSalida")
    private Integer detalleSalida_iddetalleSalida;

    @Column(name = "motivoMerma")
    private String motivoMerma;

    @Column(name = "descripcion")
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
package edu.bodega.yessy.back_sol.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_merma")
public class DetalleMerma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddetalleMerma;

    @ManyToOne
    @JoinColumn(name = "id_detalle_salida", nullable = false)
    private DetalleSalida detalleSalida;

    @Column(name = "motivo_merma", nullable = false)
    private String motivoMerma;

    @Column(name = "descripcion")
    private String descripcion;

    public Integer getIddetalleMerma() {
        return iddetalleMerma;
    }

    public void setIddetalleMerma(Integer iddetalleMerma) {
        this.iddetalleMerma = iddetalleMerma;
    }

    public DetalleSalida getDetalleSalida() {
        return detalleSalida;
    }

    public void setDetalleSalida(DetalleSalida detalleSalida) {
        this.detalleSalida = detalleSalida;
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
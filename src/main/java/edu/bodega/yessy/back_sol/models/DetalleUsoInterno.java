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
@Table(name = "detalle_uso_interno")
public class DetalleUsoInterno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddetalleusoInterno;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_detalle_salida", nullable = false)
    private DetalleSalida detalleSalida;

    @ManyToOne
    @JoinColumn(name="id_area_uso_interno", nullable = false)
    private AreaUsoInterno areausoInterno;

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

    public DetalleSalida getDetalleSalida() {
        return detalleSalida;
    }

    public void setDetalleSalida(DetalleSalida detalleSalida) {
        this.detalleSalida = detalleSalida;
    }

    public AreaUsoInterno getAreausoInterno() {
        return areausoInterno;
    }

    public void setAreausoInterno(AreaUsoInterno areausoInterno) {
        this.areausoInterno = areausoInterno;
    }
}
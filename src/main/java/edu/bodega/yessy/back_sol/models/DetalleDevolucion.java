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
@Table(name = "detalle_devolucion")
public class DetalleDevolucion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddetalleDevolucion;

    @ManyToOne
    @JoinColumn(name = "id_detalle_salida", nullable = false)
    private DetalleSalida detalleSalida;

    @Column(name = "motivo", nullable = false)
    private String motivo;

    public Integer getIddetalleDevolucion() {
        return iddetalleDevolucion;
    }

    public void setIddetalleDevolucion(Integer iddetalleDevolucion) {
        this.iddetalleDevolucion = iddetalleDevolucion;
    }

    public DetalleSalida getDetalleSalida() {
        return detalleSalida;
    }

    public void setDetalleSalida(DetalleSalida detalleSalida) {
        this.detalleSalida = detalleSalida;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
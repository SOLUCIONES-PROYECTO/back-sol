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
@Table(name = "detalle_nea")
public class DetalleNea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddetalleNea;

    @Column(name = "motivo", nullable = false)
    private String motivo;

    @Column(name = "observaciones")
    private String observaciones;

    @ManyToOne
    @JoinColumn(name="id_detalle_entrada", nullable = false)
    private DetalleEntrada detalleEntrada;

    @ManyToOne
    @JoinColumn(name = "id_proveedor", nullable = false)
    private Proveedor proveedor;

    public Integer getIddetalleNea() {
        return iddetalleNea;
    }

    public void setIddetalleNea(Integer iddetalleNea) {
        this.iddetalleNea = iddetalleNea;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public DetalleEntrada getDetalleEntrada() {
        return detalleEntrada;
    }

    public void setDetalleEntrada(DetalleEntrada detalleEntrada) {
        this.detalleEntrada = detalleEntrada;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
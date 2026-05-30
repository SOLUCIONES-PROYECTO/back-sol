package edu.bodega.yessy.back_sol.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "detallenea")
public class DetalleNea {

    @Id
    private Integer iddetalleNea;

    private String motivo;
    private String observaciones;

    private Integer detalleEntrada_iddetalleEntrada;
    private Integer proveedor_idProveedor;
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
    public Integer getDetalleEntrada_iddetalleEntrada() {
        return detalleEntrada_iddetalleEntrada;
    }
    public void setDetalleEntrada_iddetalleEntrada(Integer detalleEntrada_iddetalleEntrada) {
        this.detalleEntrada_iddetalleEntrada = detalleEntrada_iddetalleEntrada;
    }
    public Integer getProveedor_idProveedor() {
        return proveedor_idProveedor;
    }
    public void setProveedor_idProveedor(Integer proveedor_idProveedor) {
        this.proveedor_idProveedor = proveedor_idProveedor;
    }

    
}

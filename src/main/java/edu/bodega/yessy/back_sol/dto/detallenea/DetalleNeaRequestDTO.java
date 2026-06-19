package edu.bodega.yessy.back_sol.dto.detallenea;

public class DetalleNeaRequestDTO {

    private String motivo;
    private String observaciones;

    private Integer idDetalleEntrada;
    private Integer idProveedor;
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
    public Integer getIdDetalleEntrada() {
        return idDetalleEntrada;
    }
    public void setIdDetalleEntrada(Integer idDetalleEntrada) {
        this.idDetalleEntrada = idDetalleEntrada;
    }
    public Integer getIdProveedor() {
        return idProveedor;
    }
    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }
}

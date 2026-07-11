package edu.bodega.yessy.back_sol.dto.detallenea;

public class DetalleNeaResponseDTO {

    private Integer idDetalleNea;

    // Datos del detalle de entrada
    private Integer idDetalleEntrada;
    private Integer idProducto;
    private String nombreProducto;
    private String numeroDocumentoEntrada;

    // Proveedor
    private Integer idProveedor;
    private String nombreProveedor;

    // Datos NEA
    private String motivo;
    private String observaciones;
    public Integer getIdDetalleNea() {
        return idDetalleNea;
    }
    public void setIdDetalleNea(Integer idDetalleNea) {
        this.idDetalleNea = idDetalleNea;
    }
    public Integer getIdDetalleEntrada() {
        return idDetalleEntrada;
    }
    public void setIdDetalleEntrada(Integer idDetalleEntrada) {
        this.idDetalleEntrada = idDetalleEntrada;
    }
    public Integer getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
    public String getNombreProducto() {
        return nombreProducto;
    }
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public String getNumeroDocumentoEntrada() {
        return numeroDocumentoEntrada;
    }
    public void setNumeroDocumentoEntrada(String numeroDocumentoEntrada) {
        this.numeroDocumentoEntrada = numeroDocumentoEntrada;
    }
    public Integer getIdProveedor() {
        return idProveedor;
    }
    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }
    public String getNombreProveedor() {
        return nombreProveedor;
    }
    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
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
}

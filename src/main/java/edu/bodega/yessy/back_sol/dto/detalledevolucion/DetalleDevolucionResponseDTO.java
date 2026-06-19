package edu.bodega.yessy.back_sol.dto.detalledevolucion;

public class DetalleDevolucionResponseDTO {

    private Integer idDetalleDevolucion;

    private Integer idDetalleSalida;

    private Integer idProducto;
    private String nombreProducto;

    private Integer idDocSalida;
    private String numeroDocumentoSalida;

    // Motivo de devolución
    private String motivo;

    public Integer getIdDetalleDevolucion() {
        return idDetalleDevolucion;
    }

    public void setIdDetalleDevolucion(Integer idDetalleDevolucion) {
        this.idDetalleDevolucion = idDetalleDevolucion;
    }

    public Integer getIdDetalleSalida() {
        return idDetalleSalida;
    }

    public void setIdDetalleSalida(Integer idDetalleSalida) {
        this.idDetalleSalida = idDetalleSalida;
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

    public Integer getIdDocSalida() {
        return idDocSalida;
    }

    public void setIdDocSalida(Integer idDocSalida) {
        this.idDocSalida = idDocSalida;
    }

    public String getNumeroDocumentoSalida() {
        return numeroDocumentoSalida;
    }

    public void setNumeroDocumentoSalida(String numeroDocumentoSalida) {
        this.numeroDocumentoSalida = numeroDocumentoSalida;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}

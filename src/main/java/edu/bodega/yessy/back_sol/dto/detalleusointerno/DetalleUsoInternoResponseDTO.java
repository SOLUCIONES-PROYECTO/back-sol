package edu.bodega.yessy.back_sol.dto.detalleusointerno;

public class DetalleUsoInternoResponseDTO {

    private Integer idDetalleUsoInterno;

    // Datos del área interna
    private Integer idAreaUsoInterno;
    private String nombreAreaUsoInterno;

    // Datos del movimiento (salida base)
    private Integer idDetalleSalida;
    private Integer idProducto;
    private String nombreProducto;
    private String numeroDocumentoSalida;

    // Datos del uso interno
    private String descripcion;

    public Integer getIdDetalleUsoInterno() {
        return idDetalleUsoInterno;
    }

    public void setIdDetalleUsoInterno(Integer idDetalleUsoInterno) {
        this.idDetalleUsoInterno = idDetalleUsoInterno;
    }

    public Integer getIdAreaUsoInterno() {
        return idAreaUsoInterno;
    }

    public void setIdAreaUsoInterno(Integer idAreaUsoInterno) {
        this.idAreaUsoInterno = idAreaUsoInterno;
    }

    public String getNombreAreaUsoInterno() {
        return nombreAreaUsoInterno;
    }

    public void setNombreAreaUsoInterno(String nombreAreaUsoInterno) {
        this.nombreAreaUsoInterno = nombreAreaUsoInterno;
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

    public String getNumeroDocumentoSalida() {
        return numeroDocumentoSalida;
    }

    public void setNumeroDocumentoSalida(String numeroDocumentoSalida) {
        this.numeroDocumentoSalida = numeroDocumentoSalida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

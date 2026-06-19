package edu.bodega.yessy.back_sol.dto.detallemerma;

public class DetalleMermaResponseDTO {

    private Integer idDetalleMerma;

    // Detalle salida
    private Integer idDetalleSalida;
    private Integer idProducto;
    private String nombreProducto;
    private String numeroDocumentoSalida;

    // Merma
    private String motivoMerma;
    private String descripcion;
    public Integer getIdDetalleMerma() {
        return idDetalleMerma;
    }
    public void setIdDetalleMerma(Integer idDetalleMerma) {
        this.idDetalleMerma = idDetalleMerma;
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

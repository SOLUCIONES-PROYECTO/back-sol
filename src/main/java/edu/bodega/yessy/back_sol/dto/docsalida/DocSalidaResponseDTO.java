package edu.bodega.yessy.back_sol.dto.docsalida;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DocSalidaResponseDTO {

    private Integer iddocsalida;
    private String tipoDocSalida;
    private String cliente;
    private String empleado;
    private String numeroDocumento;
    private LocalDateTime fechaRegistro;
    private LocalDate fechaEgreso;
    private String descripcion;
    private BigDecimal totalSalida;
    private String metodoPago;

    public Integer getIddocsalida() {
        return iddocsalida;
    }

    public void setIddocsalida(Integer iddocsalida) {
        this.iddocsalida = iddocsalida;
    }

    public String getTipoDocSalida() {
        return tipoDocSalida;
    }

    public void setTipoDocSalida(String tipoDocSalida) {
        this.tipoDocSalida = tipoDocSalida;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDate getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(LocalDate fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getTotalSalida() {
        return totalSalida;
    }

    public void setTotalSalida(BigDecimal totalSalida) {
        this.totalSalida = totalSalida;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
}

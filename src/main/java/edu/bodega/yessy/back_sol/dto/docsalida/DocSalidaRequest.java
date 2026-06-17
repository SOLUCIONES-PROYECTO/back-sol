package edu.bodega.yessy.back_sol.dto.docsalida;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DocSalidaRequest {

    private Integer idTipoDocSalida;
    private Integer idCliente;
    private Integer idEmpleado;
    private String numeroDocumento;
    private LocalDateTime fechaRegistro;
    private LocalDate fechaEgreso;
    private String descripcion;
    private BigDecimal totalSalida;
    private Integer idMetodoPago;

    public Integer getIdTipoDocSalida() {
        return idTipoDocSalida;
    }

    public void setIdTipoDocSalida(Integer idTipoDocSalida) {
        this.idTipoDocSalida = idTipoDocSalida;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    public Integer getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(Integer idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }
}

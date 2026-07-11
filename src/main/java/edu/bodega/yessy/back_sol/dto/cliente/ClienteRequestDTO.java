package edu.bodega.yessy.back_sol.dto.cliente;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ClienteRequestDTO {
    private Integer idPersona;
    private String codigoCliente;
    private String estado;
    private String tipoCliente;
    private BigDecimal limiteCredito;
    private String observaciones;
    private String categoriaCliente;
    private LocalDate fechaUltimaCompra;

    private String frecuenciaCompra;

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public BigDecimal getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(BigDecimal limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getCategoriaCliente() {
        return categoriaCliente;
    }

    public void setCategoriaCliente(String categoriaCliente) {
        this.categoriaCliente = categoriaCliente;
    }

    public LocalDate getFechaUltimaCompra() {
        return fechaUltimaCompra;
    }

    public void setFechaUltimaCompra(LocalDate fechaUltimaCompra) {
        this.fechaUltimaCompra = fechaUltimaCompra;
    }

    public String getFrecuenciaCompra() {
        return frecuenciaCompra;
    }

    public void setFrecuenciaCompra(String frecuenciaCompra) {
        this.frecuenciaCompra = frecuenciaCompra;
    }

    

}

package edu.bodega.yessy.back_sol.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcliente;

    @Column(name = "persona_idpersona")
    private Integer persona_Idpersona;

    @Column(name = "codigoCliente")
    private String codigoCliente;

    @Column(name = "fechaRegistro")
    private LocalDate fechaRegistro;

    private String estado;

    @Column(name = "tipoCliente")
    private String tipoCliente;

    @Column(name = "limiteCredito")
    private String limiteCredito;

    private String observaciones;

    @Column(name = "categoriaCliente")
    private String categoriaCliente;

    @Column(name = "fechaUltimaCompra")
    private LocalDate fechaUltimaCompra;

    @Column(name = "frecuenciaCompra")
    private String frecuenciaCompra;

    public Integer getIdcliente() {
    return idcliente;
}

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public Integer getPersona_Idpersona() {
        return persona_Idpersona;
    }

    public void setPersonaIdpersona(Integer persona_Idpersona) {
        this.personaIdpersona = persona_Idpersona;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
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

    public String getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(String limiteCredito) {
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

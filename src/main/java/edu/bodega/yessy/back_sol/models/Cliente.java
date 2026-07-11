package edu.bodega.yessy.back_sol.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcliente;

    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;

    @Column(name = "codigo_cliente", nullable = false)
    private String codigoCliente;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "tipo_cliente", nullable = false)
    private String tipoCliente;

    @Column(name = "limite_credito", nullable = false, precision = 10, scale = 2)
    private BigDecimal limiteCredito;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "categoria_cliente", nullable = false)
    private String categoriaCliente;

    @Column(name = "fecha_ultima_compra", nullable = false)
    private LocalDate fechaUltimaCompra;

    @Column(name = "frecuencia_compra", nullable = false)
    private String frecuenciaCompra;

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
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

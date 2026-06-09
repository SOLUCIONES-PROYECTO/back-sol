package edu.bodega.yessy.back_sol.models;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "docsalida")
public class DocSalida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddocsalida;

    @Column(name = "`tipodocsalida_idtipodocsalida`")
    private Integer tipodocsalida_idtipodocsalida;

    @Column(name = "`cliente_idcliente`")
    private Integer cliente_idcliente;

    @Column(name = "`empleado_idempleado`")
    private Integer empleado_idempleado;

    @Column(name = "`numeroDocumento`")
    private String numeroDocumento;

    @Column (name = "`fechaRegistro`")
    private Timestamp fechaRegistro;

    @Column(name = "`fechaEgreso`")
    private Date fechaEgreso;

    @Column (name = "`descripcion`")
    private String descripcion;

    @Column (name = "`totalSalida`")
    private BigDecimal totalSalida;

    @Column(name = "`metododepago_idmetododepago`")
    private Integer metododepago_idmetododepago;

    public Integer getIddocsalida() {
        return iddocsalida;
    }

    public void setIddocsalida(Integer iddocsalida) {
        this.iddocsalida = iddocsalida;
    }

    public Integer getTipodocsalida_idtipodocsalida() {
        return tipodocsalida_idtipodocsalida;
    }

    public void setTipodocsalida_idtipodocsalida(Integer tipodocsalida_idtipodocsalida) {
        this.tipodocsalida_idtipodocsalida = tipodocsalida_idtipodocsalida;
    }

    public Integer getCliente_idcliente() {
        return cliente_idcliente;
    }

    public void setCliente_idcliente(Integer cliente_idcliente) {
        this.cliente_idcliente = cliente_idcliente;
    }

    public Integer getEmpleado_idempleado() {
        return empleado_idempleado;
    }

    public void setEmpleado_idempleado(Integer empleado_idempleado) {
        this.empleado_idempleado = empleado_idempleado;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(Date fechaEgreso) {
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

    public Integer getMetododepago_idmetododepago() {
        return metododepago_idmetododepago;
    }

    public void setMetododepago_idmetododepago(Integer metododepago_idmetododepago) {
        this.metododepago_idmetododepago = metododepago_idmetododepago;
    }
}

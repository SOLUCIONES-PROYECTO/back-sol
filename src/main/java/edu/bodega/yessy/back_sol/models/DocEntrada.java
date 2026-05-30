package edu.bodega.yessy.back_sol.models;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "docentrada")
public class DocEntrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddocentrada;

    @Column(name = "tipodocentrada_idtipodocentrada")
    private Integer tipodocentrada_idtipodocentrada;

    @Column(name = "metododepago_idmetododepago")
    private Integer metododepago_idmetododepago;

    @Column(name = "estadoPago_idestadoPago")
    private Integer estadoPago_idestadoPago;

    @Column(name = "estadoIngreso_idestadoIngreso")
    private Integer estadoIngreso_idestadoIngreso;

    @Column(name = "empleado_idempleado")
    private Integer empleado_idempleado;

    @Column(name = "proveedor_idProveedor")
    private Integer proveedor_idProveedor;

    @Column
    private String numeroDocumento;

    @Column
    private Date fecha_ingreso;

    @Column
    private String incidencias;

    @Column
    private BigDecimal precioTotal;

    public Integer getIddocentrada() {
        return iddocentrada;
    }

    public void setIddocentrada(Integer iddocentrada) {
        this.iddocentrada = iddocentrada;
    }

    public Integer getTipodocentrada_idtipodocentrada() {
        return tipodocentrada_idtipodocentrada;
    }

    public void setTipodocentrada_idtipodocentrada(Integer tipodocentrada_idtipodocentrada) {
        this.tipodocentrada_idtipodocentrada = tipodocentrada_idtipodocentrada;
    }

    public Integer getMetododepago_idmetododepago() {
        return metododepago_idmetododepago;
    }

    public void setMetododepago_idmetododepago(Integer metododepago_idmetododepago) {
        this.metododepago_idmetododepago = metododepago_idmetododepago;
    }

    public Integer getEstadoPago_idestadoPago() {
        return estadoPago_idestadoPago;
    }

    public void setEstadoPago_idestadoPago(Integer estadoPago_idestadoPago) {
        this.estadoPago_idestadoPago = estadoPago_idestadoPago;
    }

    public Integer getEstadoIngreso_idestadoIngreso() {
        return estadoIngreso_idestadoIngreso;
    }

    public void setEstadoIngreso_idestadoIngreso(Integer estadoIngreso_idestadoIngreso) {
        this.estadoIngreso_idestadoIngreso = estadoIngreso_idestadoIngreso;
    }

    public Integer getEmpleado_idempleado() {
        return empleado_idempleado;
    }

    public void setEmpleado_idempleado(Integer empleado_idempleado) {
        this.empleado_idempleado = empleado_idempleado;
    }

    public Integer getProveedor_idProveedor() {
        return proveedor_idProveedor;
    }

    public void setProveedor_idProveedor(Integer proveedor_idProveedor) {
        this.proveedor_idProveedor = proveedor_idProveedor;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getIncidencias() {
        return incidencias;
    }

    public void setIncidencias(String incidencias) {
        this.incidencias = incidencias;
    }

    public BigDecimal getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(BigDecimal precioTotal) {
        this.precioTotal = precioTotal;
    }
}

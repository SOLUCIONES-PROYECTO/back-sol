package edu.bodega.yessy.back_sol.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idempleado")
    private Integer idempleado;
    @Column(name = "persona_idpersona")
    private Integer persona_idpersona;

    @Column
    private String cargo;
    @Column
    private String area;
    @Column
    private LocalDate fechaContratacion;
    @Column
    private String estado;
    @Column
    private String usuarioSistema;
    @Column
    private String rol;
    @Column
    private LocalDate fechaRegistro;
    @Column
    private String turnoTrabajo;
    @Column
    private String supervisorDirecto;

    public Integer getIdempleado() {
        return idempleado;
    }
    public void setIdempleado(Integer idempleado) {
        this.idempleado = idempleado;
    }
    public Integer getPersona_idpersona() {
        return persona_idpersona;
    }
    public void setPersona_idpersona(Integer persona_idpersona) {
        this.persona_idpersona = persona_idpersona;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }
    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getUsuarioSistema() {
        return usuarioSistema;
    }
    public void setUsuarioSistema(String usuarioSistema) {
        this.usuarioSistema = usuarioSistema;
    }
    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }
    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public String getTurnoTrabajo() {
        return turnoTrabajo;
    }
    public void setTurnoTrabajo(String turnoTrabajo) {
        this.turnoTrabajo = turnoTrabajo;
    }
    public String getSupervisorDirecto() {
        return supervisorDirecto;
    }
    public void setSupervisorDirecto(String supervisorDirecto) {
        this.supervisorDirecto = supervisorDirecto;
    }
}
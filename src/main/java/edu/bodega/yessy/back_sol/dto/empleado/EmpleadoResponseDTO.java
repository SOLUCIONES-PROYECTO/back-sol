package edu.bodega.yessy.back_sol.dto.empleado;

import java.time.LocalDate;

public class EmpleadoResponseDTO {

    private Integer idEmpleado;

    // Persona
    private Integer idPersona;
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String correo;

    // Empleado
    private String cargo;
    private String area;
    private String estado;
    private String rol;
    private String usuarioSistema;
    private String turnoTrabajo;
    private String supervisorDirecto;
    private LocalDate fechaContratacion;

    
    public Integer getIdEmpleado() {
        return idEmpleado;
    }
    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    public Integer getIdPersona() {
        return idPersona;
    }
    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
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
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
    public String getUsuarioSistema() {
        return usuarioSistema;
    }
    public void setUsuarioSistema(String usuarioSistema) {
        this.usuarioSistema = usuarioSistema;
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
    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }
    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    
}
package edu.bodega.yessy.back_sol.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estado_ingreso")
public class EstadoIngreso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idestadoIngreso;

    @Column (name = "nombre", nullable = false)
    private String nombre;

    public Integer getIdestadoIngreso() {
        return idestadoIngreso;
    }

    public void setIdestadoIngreso(Integer idestadoIngreso) {
        this.idestadoIngreso = idestadoIngreso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
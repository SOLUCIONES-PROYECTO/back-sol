package edu.bodega.yessy.back_sol.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estadoingreso")
public class EstadoIngreso {

    @Id
    private Integer idestadoIngreso;

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

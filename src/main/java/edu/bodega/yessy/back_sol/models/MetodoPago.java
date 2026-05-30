package edu.bodega.yessy.back_sol.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "metododepago")
public class MetodoPago {

    @Id
    private Integer idmetododepago;

    private String nombre;

    public Integer getIdmetododepago() {
        return idmetododepago;
    }

    public void setIdmetododepago(Integer idmetododepago) {
        this.idmetododepago = idmetododepago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

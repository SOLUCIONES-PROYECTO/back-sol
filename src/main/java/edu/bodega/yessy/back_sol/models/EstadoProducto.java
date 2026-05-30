package edu.bodega.yessy.back_sol.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estadoproducto")
public class EstadoProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idestadoProducto;
    private String nombre;

    public Integer getIdestadoProducto() {
        return idestadoProducto;
    }
    public void setIdestadoProducto(Integer idestadoProducto) {
        this.idestadoProducto = idestadoProducto;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

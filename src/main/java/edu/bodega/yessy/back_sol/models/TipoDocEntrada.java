package edu.bodega.yessy.back_sol.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipodocentrada")
public class TipoDocEntrada {

    @Id
    private Integer idtipodocentrada;

    private String nombre;
    private String descripcion;
    public Integer getIdtipodocentrada() {
        return idtipodocentrada;
    }
    public void setIdtipodocentrada(Integer idtipodocentrada) {
        this.idtipodocentrada = idtipodocentrada;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}

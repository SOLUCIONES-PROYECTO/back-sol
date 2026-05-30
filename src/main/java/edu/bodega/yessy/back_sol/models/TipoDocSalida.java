package edu.bodega.yessy.back_sol.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipodocsalida")
public class TipoDocSalida {

    @Id
    private Integer idtipodocsalida;

    private String nombre;
    private String descripcion;
    public Integer getIdtipodocsalida() {
        return idtipodocsalida;
    }
    public void setIdtipodocsalida(Integer idtipodocsalida) {
        this.idtipodocsalida = idtipodocsalida;
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

package edu.bodega.yessy.back_sol.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estado_producto")
public class EstadoProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idestadoproducto")
    private Integer idestadoproducto;

    @Column (name = "nombre", nullable = false)
    private String nombre;

    public Integer getIdestadoproducto() {
        return idestadoproducto;
    }

    public void setIdestadoproducto(Integer idestadoproducto) {
        this.idestadoproducto = idestadoproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
   
}

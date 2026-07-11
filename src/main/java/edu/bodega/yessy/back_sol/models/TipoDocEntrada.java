package edu.bodega.yessy.back_sol.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_doc_entrada")
public class TipoDocEntrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idtipodocentrada;

    @Column (name = "nombre", nullable = false)
    private String nombre;

    @Column (name = "descripcion")
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
package edu.bodega.yessy.back_sol.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "AreaUsoInterno")
public class AreaUsoInterno{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAreaUsoInterno;
    private String nombre;

    public Integer getIdAreaUsoInterno() {
        return idAreaUsoInterno;
    }
    public void setIdAreaUsoInterno(Integer idAreaUsoInterno) {
        this.idAreaUsoInterno = idAreaUsoInterno;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

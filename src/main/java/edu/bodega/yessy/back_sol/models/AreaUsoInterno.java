package edu.bodega.yessy.back_sol.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "area_uso_interno")
public class AreaUsoInterno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAreaUsoInterno;

    @Column(name = "nombre", nullable = false)
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

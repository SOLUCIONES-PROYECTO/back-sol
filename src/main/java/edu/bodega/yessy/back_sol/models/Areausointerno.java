package edu.bodega.yessy.back_sol.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "areausointerno")
public class Areausointerno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idareausoInterno;

    private String nombre;

    public Integer getIdareausoInterno() {
        return idareausoInterno;
    }

    public void setIdareausoInterno(Integer idareausoInterno) {
        this.idareausoInterno = idareausoInterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

package edu.bodega.yessy.back_sol.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "unidadmedida")
public class UnidadMedida {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idunidadMedida;
    private String nombre;

    public Integer getIdunidadMedida() {
        return idunidadMedida;
    }
    public void setIdunidadMedida(Integer idunidadMedida) {
        this.idunidadMedida = idunidadMedida;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
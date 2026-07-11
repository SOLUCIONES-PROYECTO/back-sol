package edu.bodega.yessy.back_sol.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "metodo_de_pago")
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmetododepago;

    @Column (name = "nombre", nullable = false)
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
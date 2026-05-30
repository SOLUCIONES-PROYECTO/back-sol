package edu.bodega.yessy.back_sol.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estadopago")
public class EstadoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idestadoPago")
    private Integer idestadoPago;
    @Column
    private String nombre;

    public Integer getIdestadoPago() {
        return idestadoPago;
    }
    public void setIdestadoPago(Integer idestadoPago) {
        this.idestadoPago = idestadoPago;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
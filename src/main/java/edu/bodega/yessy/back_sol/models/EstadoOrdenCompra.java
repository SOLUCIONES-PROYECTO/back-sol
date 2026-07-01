package edu.bodega.yessy.back_sol.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estado_orden_compra")
public class EstadoOrdenCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idestadoOc;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    public Integer getIdestadoOc() { return idestadoOc; }
    public void setIdestadoOc(Integer idestadoOc) { this.idestadoOc = idestadoOc; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}
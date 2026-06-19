package edu.bodega.yessy.back_sol.dto.metodopago;

public class MetodoPagoResponseDTO {

    private Integer idMetodoPago;
    private String nombre;
    public Integer getIdMetodoPago() {
        return idMetodoPago;
    }
    public void setIdMetodoPago(Integer idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

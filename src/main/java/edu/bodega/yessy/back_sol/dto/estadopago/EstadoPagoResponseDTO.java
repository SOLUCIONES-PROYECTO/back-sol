package edu.bodega.yessy.back_sol.dto.estadopago;

public class EstadoPagoResponseDTO {

    private Integer idEstadoPago;
    private String nombre;
    public Integer getIdEstadoPago() {
        return idEstadoPago;
    }
    public void setIdEstadoPago(Integer idEstadoPago) {
        this.idEstadoPago = idEstadoPago;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

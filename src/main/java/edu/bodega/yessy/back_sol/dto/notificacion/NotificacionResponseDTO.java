package edu.bodega.yessy.back_sol.dto.notificacion;

public class NotificacionResponseDTO {
    private String tipo;
    private String mensaje;
    private String enlace;

    public NotificacionResponseDTO(String tipo, String mensaje, String enlace) {
        this.tipo = tipo;
        this.mensaje = mensaje;
        this.enlace = enlace;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
}

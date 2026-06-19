package edu.bodega.yessy.back_sol.dto.auth;

public class RegisterResponse {

    private String mensaje;
    private String usuarioSistema;
    private String rol;

    public RegisterResponse() {
    }

    public RegisterResponse(String mensaje, String usuarioSistema, String rol) {
        this.mensaje = mensaje;
        this.usuarioSistema = usuarioSistema;
        this.rol = rol;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getUsuarioSistema() {
        return usuarioSistema;
    }

    public String getRol() {
        return rol;
    }
}
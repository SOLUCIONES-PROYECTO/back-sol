package edu.bodega.yessy.back_sol.dto.auth;

public class LoginResponse {

    private String token;
    private String tipo;
    private Long expiraEnMs;
    private String usuarioSistema;
    private String rol;
    private String cargo;

    public LoginResponse() {
    }

    public LoginResponse(String token, String tipo, Long expiraEnMs, String usuarioSistema, String rol, String cargo) {
        this.token = token;
        this.tipo = tipo;
        this.expiraEnMs = expiraEnMs;
        this.usuarioSistema = usuarioSistema;
        this.rol = rol;
        this.cargo = cargo;
    }

    public String getToken() {
        return token;
    }

    public String getTipo() {
        return tipo;
    }

    public Long getExpiraEnMs() {
        return expiraEnMs;
    }

    public String getUsuarioSistema() {
        return usuarioSistema;
    }

    public String getRol() {
        return rol;
    }

    public String getCargo() {
        return cargo;
    }
}
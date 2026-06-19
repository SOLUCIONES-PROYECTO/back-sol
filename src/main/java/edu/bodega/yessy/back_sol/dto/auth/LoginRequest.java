package edu.bodega.yessy.back_sol.dto.auth;

public class LoginRequest {

    private String usuarioSistema;
    private String password;

    public LoginRequest() {
    }

    public LoginRequest(String usuarioSistema, String password) {
        this.usuarioSistema = usuarioSistema;
        this.password = password;
    }

    public String getUsuarioSistema() {
        return usuarioSistema;
    }

    public void setUsuarioSistema(String usuarioSistema) {
        this.usuarioSistema = usuarioSistema;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
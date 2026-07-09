package edu.bodega.yessy.back_sol.dto.auth;

public class CambiarContraseñaRequest {
    private String nuevaContrasena;

    public String getNuevaContrasena() {
        return nuevaContrasena;
    }

    public void setNuevaContrasena(String nuevaContrasena) {
        this.nuevaContrasena = nuevaContrasena;
    }
}

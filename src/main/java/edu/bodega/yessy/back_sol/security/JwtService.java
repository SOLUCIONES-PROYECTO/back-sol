package edu.bodega.yessy.back_sol.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.models.Empleado;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration-ms}")
    private Long expirationMs;

    public String generarToken(Empleado empleado) {

        Date fechaActual = new Date();
        Date fechaExpiracion = new Date(fechaActual.getTime() + expirationMs);

        return Jwts.builder()
                .subject(empleado.getUsuarioSistema())
                .claim("idempleado", empleado.getIdempleado())
                .claim("rol", empleado.getRol())
                .claim("estado", empleado.getEstado())
                .issuedAt(fechaActual)
                .expiration(fechaExpiracion)
                .signWith(getSigningKey(), Jwts.SIG.HS256)
                .compact();
    }

    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public Long getExpirationMs() {
        return expirationMs;
    }
}
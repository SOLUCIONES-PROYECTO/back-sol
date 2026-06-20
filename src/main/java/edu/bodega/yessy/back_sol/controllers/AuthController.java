package edu.bodega.yessy.back_sol.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.bodega.yessy.back_sol.dto.auth.LoginRequest;
import edu.bodega.yessy.back_sol.dto.auth.LoginResponse;
import edu.bodega.yessy.back_sol.dto.auth.RegisterRequest;
import edu.bodega.yessy.back_sol.dto.auth.RegisterResponse;
import edu.bodega.yessy.back_sol.services.AuthService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        LoginResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request) {
        RegisterResponse response = authService.registrar(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        return ResponseEntity.ok(
                Map.of("mensaje", "Sesión cerrada correctamente")
        );
    }
}
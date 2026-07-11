package edu.bodega.yessy.back_sol.services;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import edu.bodega.yessy.back_sol.dto.auth.LoginRequest;
import edu.bodega.yessy.back_sol.dto.auth.LoginResponse;
import edu.bodega.yessy.back_sol.dto.auth.RegisterRequest;
import edu.bodega.yessy.back_sol.dto.auth.RegisterResponse;
import edu.bodega.yessy.back_sol.models.Empleado;
import edu.bodega.yessy.back_sol.models.Persona;
import edu.bodega.yessy.back_sol.repositories.EmpleadoRepository;
import edu.bodega.yessy.back_sol.repositories.PersonaRepository;
import edu.bodega.yessy.back_sol.security.JwtService;

@Service
public class AuthService {

    private final EmpleadoRepository empleadoRepository;
    private final PersonaRepository personaRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final EmailService emailService;

    public AuthService(
            EmpleadoRepository empleadoRepository,
            PersonaRepository personaRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService,
            EmailService emailService
    ) {
        this.empleadoRepository = empleadoRepository;
        this.personaRepository = personaRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.emailService = emailService;
    }

    public LoginResponse login(LoginRequest request) {

        Empleado empleado = empleadoRepository.findByUsuarioSistema(request.getUsuarioSistema())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED,
                        "Usuario o contraseña incorrectos"
                ));

        if (!"ACTIVO".equalsIgnoreCase(empleado.getEstado())) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN,
                    "El usuario no está activo"
            );
        }

        if (empleado.getContrasena() == null || empleado.getContrasena().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "El usuario no tiene contraseña configurada"
            );
        }

        boolean passwordValido = passwordEncoder.matches(
                request.getPassword(),
                empleado.getContrasena()
        );

        if (!passwordValido) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Usuario o contraseña incorrectos"
            );
        }

        String token = jwtService.generarToken(empleado);

        return new LoginResponse(
                token,
                "Bearer",
                jwtService.getExpirationMs(),
                empleado.getUsuarioSistema(),
                empleado.getRol(),
                empleado.getCargo() 
        );
    }

    public RegisterResponse registrar(RegisterRequest request) {

        if (empleadoRepository.existsByUsuarioSistema(request.getUsuarioSistema())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El usuario ya existe"
            );
        }

        Persona persona = new Persona();

        persona.setNombre(request.getNombres());
        persona.setApellido(request.getApellidos());
        persona.setDni(request.getDni());
        persona.setTelefono(request.getTelefono());
        persona.setCorreo(request.getCorreo());
        persona.setDireccion(request.getDireccion());
        persona.setFechaNacimiento(request.getFechaNacimiento());
        persona.setGenero(request.getGenero());
        persona.setFechaRegistro(LocalDateTime.now());

        Persona personaGuardada = personaRepository.save(persona);

        Empleado empleado = new Empleado();

        empleado.setPersona(personaGuardada);
        empleado.setCargo(request.getCargo());
        empleado.setArea(request.getArea());
        empleado.setFechaContratacion(LocalDate.now());
        empleado.setEstado("Activo");
        empleado.setUsuarioSistema(request.getUsuarioSistema());
        empleado.setRol("Empleado");
        empleado.setFechaRegistro(LocalDateTime.now());
        empleado.setTurnoTrabajo("Mañana");
        empleado.setSupervisorDirecto("Maria Perez");

        String passwordHash = passwordEncoder.encode(request.getPassword());
        empleado.setContrasena(passwordHash);

        empleadoRepository.save(empleado);

        return new RegisterResponse(
                "Usuario registrado correctamente",
                empleado.getUsuarioSistema(),
                empleado.getRol()
        );
    }

    public void solicitarRecuperacion(String email) {
        Empleado empleado = empleadoRepository.findByPersonaCorreo(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontró un usuario con ese correo."));

        String token = java.util.UUID.randomUUID().toString();
        System.out.println("====== TOKEN GENERADO PARA " + email + " ====== : " + token);
        empleado.setResetToken(token);
        empleado.setResetTokenExpiry(LocalDateTime.now().plusMinutes(15));
        empleadoRepository.save(empleado);

        emailService.enviarCorreoRecuperacion(email, token);
    }

    public void restablecerContrasena(String token, String nuevaContrasena) {
        System.out.println("====== RECIBIDA SOLICITUD DE RESETEO ======");
        System.out.println("Token recibido desde frontend: [" + token + "]");
        
        Empleado empleado = empleadoRepository.findByResetToken(token)
                .orElseThrow(() -> {
                    System.out.println("ERROR: No se encontró empleado con el token [" + token + "]");
                    return new ResponseStatusException(HttpStatus.BAD_REQUEST, "Token inválido o no encontrado.");
                });

        if (empleado.getResetTokenExpiry().isBefore(LocalDateTime.now())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El token ha expirado. Por favor, solicita uno nuevo.");
        }

        empleado.setContrasena(passwordEncoder.encode(nuevaContrasena));
        empleado.setResetToken(null);
        empleado.setResetTokenExpiry(null);
        empleadoRepository.save(empleado);
    }
}
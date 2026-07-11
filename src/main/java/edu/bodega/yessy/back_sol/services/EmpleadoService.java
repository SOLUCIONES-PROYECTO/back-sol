package edu.bodega.yessy.back_sol.services;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bodega.yessy.back_sol.dto.empleado.EmpleadoRequestDTO;
import edu.bodega.yessy.back_sol.dto.empleado.EmpleadoResponseDTO;
import edu.bodega.yessy.back_sol.models.Empleado;
import edu.bodega.yessy.back_sol.models.Persona;
import edu.bodega.yessy.back_sol.repositories.EmpleadoRepository;
import edu.bodega.yessy.back_sol.repositories.PersonaRepository;

@Service
public class EmpleadoService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final EmpleadoRepository empleadoRepository;
    private final PersonaRepository personaRepository;

    public EmpleadoService(
            EmpleadoRepository empleadoRepository,
            PersonaRepository personaRepository) {
        this.empleadoRepository = empleadoRepository;
        this.personaRepository = personaRepository;
    }

    // ================= LISTAR =================
    @Transactional(readOnly = true)
    public ArrayList<EmpleadoResponseDTO> listar() {

        ArrayList<EmpleadoResponseDTO> lista = new ArrayList<>();

        for (Empleado empleado : empleadoRepository.findAll()) {
            lista.add(convertirDTO(empleado));
        }

        return lista;
    }

    // ================= BUSCAR =================
    @Transactional(readOnly = true)
    public EmpleadoResponseDTO buscarPorId(Integer id) {

        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        return convertirDTO(empleado);
    }

    // ================= CREAR =================
    @Transactional
    public EmpleadoResponseDTO guardar(EmpleadoRequestDTO dto) {

        if (empleadoRepository.existsByUsuarioSistema(dto.getUsuarioSistema())) {
            throw new RuntimeException("El usuario del sistema ya existe");
        }

        Persona persona = personaRepository.findById(dto.getIdPersona())
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        Empleado empleado = new Empleado();

        empleado.setPersona(persona);

        empleado.setCargo(dto.getCargo());
        empleado.setArea(dto.getArea());
        empleado.setFechaContratacion(dto.getFechaContratacion());

        empleado.setEstado(dto.getEstado());
        empleado.setRol(dto.getRol());

        empleado.setUsuarioSistema(dto.getUsuarioSistema());

        empleado.setTurnoTrabajo(dto.getTurnoTrabajo());
        empleado.setSupervisorDirecto(dto.getSupervisorDirecto());

        empleado.setFechaRegistro(LocalDateTime.now());

        return convertirDTO(
                empleadoRepository.save(empleado));
    }

    // ================= ACTUALIZAR =================
    @Transactional
    public EmpleadoResponseDTO actualizar(
            Integer id,
            EmpleadoRequestDTO dto) {

        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        Persona persona = personaRepository.findById(dto.getIdPersona())
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        empleado.setPersona(persona);

        empleado.setCargo(dto.getCargo());
        empleado.setArea(dto.getArea());
        empleado.setFechaContratacion(dto.getFechaContratacion());

        empleado.setEstado(dto.getEstado());
        empleado.setRol(dto.getRol());

        empleado.setUsuarioSistema(dto.getUsuarioSistema());

        empleado.setTurnoTrabajo(dto.getTurnoTrabajo());
        empleado.setSupervisorDirecto(dto.getSupervisorDirecto());

        return convertirDTO(
                empleadoRepository.save(empleado));
    }

    // ================= ELIMINAR =================
    @Transactional
    public void eliminar(Integer id) {

        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        empleado.setEstado("Inactivo");
        empleadoRepository.save(empleado);
    }

    // ================= MAPPER =================
    private EmpleadoResponseDTO convertirDTO(Empleado empleado) {

        EmpleadoResponseDTO dto = new EmpleadoResponseDTO();

        dto.setIdEmpleado(empleado.getIdempleado());

        dto.setIdPersona(empleado.getPersona().getIdpersona());
        dto.setNombre(empleado.getPersona().getNombre());
        dto.setApellido(empleado.getPersona().getApellido());
        dto.setDni(empleado.getPersona().getDni());
        dto.setTelefono(empleado.getPersona().getTelefono());
        dto.setCorreo(empleado.getPersona().getCorreo());

        dto.setCargo(empleado.getCargo());
        dto.setArea(empleado.getArea());
        dto.setEstado(empleado.getEstado());
        dto.setRol(empleado.getRol());
        dto.setUsuarioSistema(empleado.getUsuarioSistema());
        dto.setTurnoTrabajo(empleado.getTurnoTrabajo());
        dto.setSupervisorDirecto(empleado.getSupervisorDirecto());
        dto.setFechaContratacion(empleado.getFechaContratacion());

        return dto;
    }

    @Transactional
    public void cambiarContrasena(Integer id, String nuevaContrasena) {

        if (nuevaContrasena == null || nuevaContrasena.isBlank()) {
            throw new RuntimeException("La nueva contraseña no puede estar vacía");
        }

        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        empleado.setContrasena(passwordEncoder.encode(nuevaContrasena));
        empleadoRepository.save(empleado);
    }

    
}
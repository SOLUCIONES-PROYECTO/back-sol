package edu.bodega.yessy.back_sol.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bodega.yessy.back_sol.models.Empleado;
import edu.bodega.yessy.back_sol.repositories.EmpleadoRepository;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Transactional(readOnly = true)
    public List<Empleado> listar() {
        return empleadoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Empleado buscarPorId(Integer id) {
        return empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
    }

    @Transactional
    public Empleado guardar(Empleado empleado) {

        if (empleadoRepository.existsByUsuarioSistema(empleado.getUsuarioSistema())) {
            throw new RuntimeException("El usuario del sistema ya existe");
        }

        empleado.setFechaRegistro(LocalDateTime.now());

        return empleadoRepository.save(empleado);
    }

    @Transactional
    public Empleado actualizar(Integer id, Empleado empleadoActualizado) {

        Empleado empleado = buscarPorId(id);

        empleado.setPersona(empleadoActualizado.getPersona());
        empleado.setCargo(empleadoActualizado.getCargo());
        empleado.setArea(empleadoActualizado.getArea());
        empleado.setFechaContratacion(empleadoActualizado.getFechaContratacion());
        empleado.setEstado(empleadoActualizado.getEstado());
        empleado.setUsuarioSistema(empleadoActualizado.getUsuarioSistema());
        empleado.setRol(empleadoActualizado.getRol());
        empleado.setTurnoTrabajo(empleadoActualizado.getTurnoTrabajo());
        empleado.setSupervisorDirecto(empleadoActualizado.getSupervisorDirecto());

        return empleadoRepository.save(empleado);
    }

    @Transactional
    public void eliminar(Integer id) {
        Empleado empleado = buscarPorId(id);
        empleadoRepository.delete(empleado);
    }
}
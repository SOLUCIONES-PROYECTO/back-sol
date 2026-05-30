package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.models.Empleado;
import edu.bodega.yessy.back_sol.repositories.EmpleadoRepository;

@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;

    public ArrayList<Empleado> listar() {
        return (ArrayList<Empleado>) empleadoRepository.findAll();
    }

    public Empleado nuevo(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }
}

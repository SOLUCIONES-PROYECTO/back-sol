package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.models.EstadoIngreso;
import edu.bodega.yessy.back_sol.repositories.EstadoIngresoRepository;

@Service
public class EstadoIngresoService {

    @Autowired
    EstadoIngresoRepository estadoIngresoRepository;

    public ArrayList<EstadoIngreso> listar() {
        return (ArrayList<EstadoIngreso>) estadoIngresoRepository.findAll();
    }

    public EstadoIngreso nuevo(EstadoIngreso estadoIngreso) {
        return estadoIngresoRepository.save(estadoIngreso);
    }
}
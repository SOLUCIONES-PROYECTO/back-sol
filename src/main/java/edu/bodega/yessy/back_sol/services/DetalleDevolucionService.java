package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.models.DetalleDevolucion;
import edu.bodega.yessy.back_sol.repositories.DetalleDevolucionRepository;

@Service
public class DetalleDevolucionService {

    @Autowired
    DetalleDevolucionRepository detalleDevolucionRepository;

    public ArrayList<DetalleDevolucion> listar() {
        return (ArrayList<DetalleDevolucion>) detalleDevolucionRepository.findAll();
    }

    public DetalleDevolucion nuevo(DetalleDevolucion detalleDevolucion) {
        return detalleDevolucionRepository.save(detalleDevolucion);
    }
}

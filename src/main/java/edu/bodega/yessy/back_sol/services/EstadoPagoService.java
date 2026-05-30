package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.models.EstadoPago;
import edu.bodega.yessy.back_sol.repositories.EstadoPagoRepository;

@Service
public class EstadoPagoService {

    @Autowired
    EstadoPagoRepository estadoPagoRepository;

    public ArrayList<EstadoPago> listar() {
        return (ArrayList<EstadoPago>) estadoPagoRepository.findAll();
    }

    public EstadoPago nuevo(EstadoPago estadoPago) {
        return estadoPagoRepository.save(estadoPago);
    }
}

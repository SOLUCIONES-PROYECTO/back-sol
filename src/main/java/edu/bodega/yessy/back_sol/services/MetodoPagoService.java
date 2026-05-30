package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.models.MetodoPago;
import edu.bodega.yessy.back_sol.repositories.MetodoPagoRepository;

@Service
public class MetodoPagoService {

    @Autowired
    MetodoPagoRepository metodoPagoRepository;

    public ArrayList<MetodoPago> listar() {
        return (ArrayList<MetodoPago>) metodoPagoRepository.findAll();
    }

    public MetodoPago nuevo(MetodoPago metodoPago) {
        return metodoPagoRepository.save(metodoPago);
    }
}

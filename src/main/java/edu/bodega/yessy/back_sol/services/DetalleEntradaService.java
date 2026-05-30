package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.models.DetalleEntrada;
import edu.bodega.yessy.back_sol.repositories.DetalleEntradaRepository;

@Service
public class DetalleEntradaService {

    @Autowired
    DetalleEntradaRepository detalleEntradaRepository;

    public ArrayList<DetalleEntrada> listar() {
        return (ArrayList<DetalleEntrada>) detalleEntradaRepository.findAll();
    }

    public DetalleEntrada nuevo(DetalleEntrada detalleEntrada) {
        return detalleEntradaRepository.save(detalleEntrada);
    }
}
